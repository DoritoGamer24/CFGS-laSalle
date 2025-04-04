#pragma once
#include <SFML/Graphics.hpp>
#include <SFML/Audio.hpp>
#include <vector>
#include "Hero.h"
#include "Enemy.h"
#include "Rocket.h"

using namespace sf;

class Engine {
private:
	//creem la variables per crear la finestra de joc
	Vector2f viewSize;
	VideoMode vm;
	RenderWindow window;

	//-----------------------------------------------------------

	//variable per emmagatzemar el fons
	//cel
	Texture skyTexture;
	Sprite skySprite;

	//-----------------------------------------------------------

	//paisatge
	Texture bgTexture;
	Sprite bgSprite;

	//-----------------------------------------------------------

	// Text
	Font headingFont;
	Text headingText;
	Font scoreFont;
	Text scoreText;
	Text tutorialText;

	//-----------------------------------------------------------

	// Audio
	Music bgMusic;

	Music wiiStart;

	SoundBuffer hitBuffer;
	Sound hit;

	SoundBuffer hurtBuffer;
	Sound hurt;

	SoundBuffer deathBuffer;
	Sound death;

	//-----------------------------------------------------------

	//barra de vida
	int playerHealth = 3;

	RectangleShape healthBar;
	Font healthFont;
	Text healthText;


	//-----------------------------------------------------------

	//variable del personatge
	Hero Iker;
	std::vector<Enemy*> enemies;

	std::vector<Rocket*> rockets;

	//temps entre frame
	float currentTime;
	float prevTime = 0.0f;

	//-----------------------------------------------------------

	//variables del joc.
	int score = 0;
	bool gameover = true;
	bool checkCollision(Sprite sprite1, Sprite sprite2);
	void shoot();
	void reset();
	void init();
	void updateInput();
	void spawnEnemy();
	void update(float dt);
	void updateHealth();
	void draw();

public:
	// This is the constructor, called whenever a 'Game' object is created.
	// Use this to setup stuff you have to set once.
	// This should only be used for things that can't fail, to always have a defined state.
	Engine();

	//------------------------------------------------------------

	// This is the destructor, called whenever a 'Game' object is destroyed.
	~Engine();

	//------------------------------------------------------------

	// Load and run the game
	int run();
};

