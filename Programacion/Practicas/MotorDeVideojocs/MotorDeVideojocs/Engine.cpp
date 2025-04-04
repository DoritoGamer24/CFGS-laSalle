#include "Engine.h"
#include "Enemy.h"
#include "Rocket.h"
#include <vector>
#include <sstream>

using namespace sf;

int score = 0;  
std::stringstream ss;

// This is the constructor, called whenever a 'Game' object is init.
Engine::Engine() {
	// Get the screen resolution and create an SFML window and View
	//mides de la finestra
	viewSize.x = 2560;
	viewSize.y = 1340;
	//construïm la finestra de joc.
	window.create(VideoMode(viewSize.x, viewSize.y), "Joc heroi - enemic", Style::Fullscreen);
}

//---------------------------------------------------------------------------------------------------

// This is the destructor, called whenever a 'Game' object is destroyed.
Engine::~Engine() {
}

//---------------------------------------------------------------------------------------------------

// Load and run the game
int Engine::run() {
	Clock clock;
	init();
	while (window.isOpen()) {
		updateInput();
		Time dt = clock.restart();
		if (!gameover) {
			update(dt.asSeconds());
		}
		draw();
	}
	return 0;
}

//---------------------------------------------------------------------------------------------------

void Engine::init() {
	//carregam les imatges del fons
	skyTexture.loadFromFile("Assets/graphics/sky.png");
	skySprite.setTexture(skyTexture);
	bgTexture.loadFromFile("Assets/graphics/bg.png");
	bgSprite.setTexture(bgTexture);


	// Load font
	headingFont.loadFromFile("Assets/fonts/contb.ttf");
	scoreFont.loadFromFile("Assets/fonts/contb.ttf");


	// Set Heading Text
	headingText.setFont(headingFont);
	headingText.setString("Mii Channel: Pau Attack");
	headingText.setCharacterSize(84);
	headingText.setFillColor(Color::Color(85, 126, 128));
	FloatRect headingbounds = headingText.getLocalBounds();
	headingText.setOrigin(headingbounds.width / 2, headingbounds.height / 2);
	headingText.setPosition(Vector2f(viewSize.x * 0.5f, viewSize.y * 0.4f));


	// Set Score Text
	scoreText.setFont(scoreFont);
	ss << "Score: " << score;
	scoreText.setString(ss.str());
	scoreText.setCharacterSize(84);
	scoreText.setFillColor(Color::Color(85, 126, 128));
	// Ajustar la posición del texto
	FloatRect scorebounds = scoreText.getLocalBounds();
	scoreText.setOrigin(scorebounds.width / 2, scorebounds.height / 2);
	scoreText.setPosition(Vector2f(viewSize.x * 0.5f, viewSize.y * 0.9f));


	// Tutorial Text
	tutorialText.setFont(scoreFont);
	tutorialText.setString("Press S to Fire and Start Game, W to Jump");
	tutorialText.setCharacterSize(35);
	tutorialText.setFillColor(Color::Color(85, 126, 128));
	FloatRect tutorialbounds = tutorialText.getLocalBounds();
	tutorialText.setOrigin(tutorialbounds.width / 2, tutorialbounds.height / 2);
	tutorialText.setPosition(Vector2f(viewSize.x * 0.5f, viewSize.y * 0.5f));


	// Audio
	bgMusic.openFromFile("Assets/audio/bgMusic.ogg");
	bgMusic.play();
	wiiStart.openFromFile("Assets/audio/wiiStart.ogg");
	wiiStart.play();

	//Sound
	hitBuffer.loadFromFile("Assets/audio/hit.ogg");
	hit.setBuffer(hitBuffer);

	hurtBuffer.loadFromFile("Assets/audio/hurt.ogg");
	hurt.setBuffer(hurtBuffer);

	deathBuffer.loadFromFile("Assets/audio/death.ogg");
	death.setBuffer(deathBuffer);


	//inicialitzem el jugador
	Iker.init("Assets/graphics/hero.png", Vector2f(viewSize.x * 0.25f, viewSize.y * 0.5f), 200);


	//inicialitzem els nombre aleatoris.
	srand((int)time(0));


	//Configurar la barra de vida
	//Color, posicion y mida
	healthBar.setSize(Vector2f(200, 20));
	healthBar.setFillColor(Color::Green);

	//Texto
	healthFont.loadFromFile("Assets/fonts/contb.ttf");
	healthText.setFont(healthFont);
	healthText.setCharacterSize(30);
	healthText.setFillColor(Color::Color(85, 126, 128));
	healthText.setPosition(240, 10);
	updateHealth();

	healthBar.setPosition(20, viewSize.y - 30);
	healthText.setPosition(20, viewSize.y - 50);
}

//---------------------------------------------------------------------------------------------------

void Engine::updateInput() {
	Event event;
	// while there are pending events...
	while (window.pollEvent(event)) {
		if (event.type == Event::KeyPressed) { //revisem les tecles premudes
			if (event.key.code == Keyboard::W) {//personatge salta
				Iker.jump(850.0f);
			}

			if (event.key.code == Keyboard::S) {
				if (gameover) {//si no joguem llavors engeguem el joc.
					gameover = false;
					reset();
				}
				else
				{
					shoot();
				}
			}
		}


	//condicions per tancar el programa
	if (event.key.code == Keyboard::Escape || event.type == Event::Closed)
		window.close();
	}
}

//---------------------------------------------------------------------------------------------------

void Engine::update(float dt) {
	//actualitzem la posició del personatge
	Iker.update(dt);
	Vector2f enemyPos;

	//modifiquem el temps per sabre el que ha passat
	currentTime += dt;

	// Spawn Enemies
	if (currentTime >= prevTime + 1.125f) {
		spawnEnemy();
		prevTime = currentTime;
	}

	// Update Enemies
	for (int i = 0; i < enemies.size(); i++) {
		Enemy* enemy = enemies[i];
		enemy->update(dt);
		// Si el enemigo toca al jugador, reducimos vida
		if (checkCollision(enemy->getSprite(), Iker.getSprite()) && enemy) {
			playerHealth--;
			updateHealth();
			delete enemy;
			enemies.erase(enemies.begin() + i);
		}

		// Si el enemigo llega al final de la pantalla, reducimos vida
		else if (enemy->getSprite().getPosition().x < 0) {
			playerHealth--;
			updateHealth();
			delete enemy;
			enemies.erase(enemies.begin() + i);
			if (playerHealth <= 0) gameover = true;
		}
	}

	//Update rockets
	for (int i = 0; i < rockets.size(); i++) {
		Rocket* rocket = rockets[i];
		rocket->update(dt);
		for (int j = 0; j < enemies.size(); j++) {
			if (checkCollision(rocket->getSprite(), enemies[j]->getSprite())) {
				hit.play();
				delete rockets[i];
				rockets.erase(rockets.begin() + i);
				delete enemies[j];
				enemies.erase(enemies.begin() + j);
				score += 1;
				ss.str("");   // Limpiar el stringstream
				ss.clear();   // Reiniciar flags de estado del stringstream
				ss << "Score: " << score;
				scoreText.setString(ss.str());
				break;
			}
		}
	}
}

//---------------------------------------------------------------------------------------------------

void Engine::draw() {
	// netejem la pantalla
	window.clear(Color::Red);

	//dibuixem elements
	window.draw(skySprite);
	window.draw(bgSprite);
	window.draw(Iker.getSprite());
	for (Enemy* enemy : enemies) {
		window.draw(enemy->getSprite());
	}
	for (Rocket* rocket : rockets) {
		window.draw(rocket->getSprite());
	}

	//mostrem text depenent si estem jugant o no
	if (gameover) {
		window.draw(headingText);
		window.draw(tutorialText);
	}
	else {
		window.draw(scoreText);
		window.draw(healthBar);
		window.draw(healthText);
	}

	//enviem a la pantalla.
	window.display();
}

//---------------------------------------------------------------------------------------------------

void Engine::reset() {
	score = 0;
	playerHealth = 3;  // Restaurar la vida del jugador
	healthBar.setFillColor(Color::Green);  // Restablecer el color de la barra de vida a verde
	updateHealth();     // Asegurar que la barra de vida se actualice visualmente
	currentTime = 0.0f;
	prevTime = 0.0;
	for (Enemy* enemy : enemies) {
		delete(enemy);
	}
	for (Rocket* rocket : rockets) {
		delete(rocket);
	}
	enemies.clear();
	rockets.clear();
}

//---------------------------------------------------------------------------------------------------

void Engine::spawnEnemy() {
	int randLoc = rand() % 3;
	sf::Vector2f enemyPos;
	float speed;
	switch (randLoc) {
	case 0: enemyPos = sf::Vector2f(viewSize.x, viewSize.y * 0.67f);
		speed = -400;
		break;
	case 1: enemyPos = sf::Vector2f(viewSize.x, viewSize.y * 0.54f);
		speed = -550;
		break;
	case 2: enemyPos = sf::Vector2f(viewSize.x, viewSize.y * 0.42f);
		speed = -650;
		break;
	default: printf("incorrect y value \n");
		break;
	}
	Enemy* enemy = new Enemy();
	enemy->init("Assets/graphics/enemy.png", enemyPos, speed);
	enemies.push_back(enemy);
}

//---------------------------------------------------------------------------------------------------

void Engine::shoot() {
	Rocket* rocket = new Rocket();
	sf::Vector2f posicion = Iker.getSprite().getPosition();
	posicion.y += 160;  // Ajusta la posición en Y
	rocket->init("Assets/graphics/rocket.png", posicion, 800);
	rockets.push_back(rocket);
}

//---------------------------------------------------------------------------------------------------

bool Engine::checkCollision(sf::Sprite sprite1, sf::Sprite sprite2) {
	sf::FloatRect shape1 = sprite1.getGlobalBounds();
	sf::FloatRect shape2 = sprite2.getGlobalBounds();
	if (shape1.intersects(shape2)) {
		return true;
	}
	else {
		return false;
	}
}

//---------------------------------------------------------------------------------------------------

void Engine::updateHealth() {
	healthBar.setSize(sf::Vector2f(playerHealth * 66.0f, 20.0f));
	if (playerHealth == 2) healthBar.setFillColor(sf::Color::Yellow);
	else if (playerHealth == 1) healthBar.setFillColor(sf::Color::Red);
	else if (playerHealth <= 0) {
		gameover = true;
		healthBar.setFillColor(sf::Color::Black);
	}

	healthText.setString("Health: " + to_string(playerHealth));
}