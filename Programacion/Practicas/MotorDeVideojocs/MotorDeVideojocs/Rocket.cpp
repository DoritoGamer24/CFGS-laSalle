#include "rocket.h"
#include "Hero.h"


Rocket::Rocket()
{
}


Rocket::~Rocket()
{
}

Sprite Rocket::getSprite() {
    return m_sprite;
}

void Rocket::update(float dt) {
	m_sprite.move(m_speed * dt, 0);
}

void Rocket::init(std::string texturePath, sf::Vector2f position, float speed) {
    m_position = position;
    m_speed = speed;

    m_texture.loadFromFile(texturePath);
    m_sprite.setTexture(m_texture);
    m_sprite.setPosition(position);
}