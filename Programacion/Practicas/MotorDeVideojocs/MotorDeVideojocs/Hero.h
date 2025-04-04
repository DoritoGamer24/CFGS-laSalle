#pragma once
#include "SFML\Graphics.hpp"

using namespace sf;

class Hero {
public:
	Hero();
	~Hero();
	void init(std::string textureName, sf::Vector2f position, float mass);
	void update(float dt);
	void jump(float velocity);
	void movement(float dt);
	Sprite getSprite();

private:
	Texture m_texture;
	Sprite m_sprite;
	Vector2f m_position;
	int jumpCount = 0;
	int m_force;
	float m_mass;
	float m_velocity;
	const float m_gravity = 9.80f;
	bool m_grounded;
};

