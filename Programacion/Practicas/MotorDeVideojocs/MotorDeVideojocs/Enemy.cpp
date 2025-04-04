#include "Enemy.h"

using namespace sf;

Sprite Enemy::getSprite() {
	return m_sprite;
}

//----+

Enemy::Enemy(){}Enemy::~Enemy()
{
}


void Enemy::init(std::string texturePath, sf::Vector2f position, float speed) {
    m_position = position;
    m_speed = speed;

    m_texture.loadFromFile(texturePath);
    m_sprite.setTexture(m_texture);
    m_sprite.setPosition(position);
}


void Enemy::update(float dt) {
    m_position.x += m_speed * dt;
    m_sprite.setPosition(m_position);
}