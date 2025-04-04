#include "Hero.h"

using namespace sf;

Sprite Hero::getSprite() {
	return m_sprite;
}

//----+

Hero::Hero() {}Hero::~Hero() 
{
}

//---------------------------------------------------------------------------------------------------

void Hero::init(std::string textureName, sf::Vector2f position, float mass) {
	m_position = position;
	m_mass = mass;
	m_grounded = false;
	// Load a Texture
	m_texture.loadFromFile(textureName.c_str());
	// Create Sprite and Attach a Texture
	m_sprite.setTexture(m_texture);
	m_sprite.setPosition(m_position);
	m_sprite.setOrigin(m_texture.getSize().x / 22, m_texture.getSize().y / 22);
}

//---------------------------------------------------------------------------------------------------

void Hero::update(float dt) {
	movement(dt);
	m_velocity -= m_mass * m_gravity * dt;
	m_position.y -= m_velocity * dt;
	m_sprite.setPosition(m_position);
	if (m_position.y >= 1000 * 0.75f) {
		m_position.y = 1000 * 0.75f;
		m_velocity = 0;
		m_grounded = true;
		jumpCount = 0;
	}
	if (m_position.x >= 2560 * 0.93f) {
		m_position.x = 2560 * 0.93f;
	}
	if (m_position.x <= 2560 * 0.03f) {
		m_position.x = 2560 * 0.03f;
	}
}

//---------------------------------------------------------------------------------------------------

void Hero::jump(float velocity) {
	if (jumpCount < 2) {
		jumpCount++;
		m_velocity = velocity;
		m_grounded = false;
	}
}


void Hero::movement(float dt) {
	float speed = 500.0f;
	if (Keyboard::isKeyPressed(Keyboard::D) || Keyboard::isKeyPressed(Keyboard::Right)) {
		m_position.x += speed * dt;
	}
	else if (Keyboard::isKeyPressed(Keyboard::A) || Keyboard::isKeyPressed(Keyboard::Left)) {
		m_position.x -= speed * dt;
	}
	else {
		m_position.x += 0.0;
	}
}