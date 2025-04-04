// PelotaYParedes.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include <SFML/Window.hpp>
#include <SFML/Graphics.hpp>
using namespace sf;

Vector2f velocidad(-6, -6);

int main()
{
	bool paused = true;

    RenderWindow window(VideoMode(1920, 1080), "BreakOut");
    window.setFramerateLimit(60);

	Sprite bola;
	bola.setOrigin(5, 5);
	bola.setPosition(window.getSize().x/2, window.getSize().y/2);
	bola.setScale(0.08f, 0.08f);
	Texture pelota;
	pelota.loadFromFile("texturas/pilota.png");
	bola.setTexture(pelota);

	while (window.isOpen())
	{
		Event event;
		while (window.pollEvent(event))
		{
			if (event.type == Event::Closed) {
				window.close();
			}
		}
		//Rebote
		if (bola.getPosition().x + 33 >= window.getSize().x || bola.getPosition().x <= 3)
		{
			//Cambiar direccion X
			velocidad.x *= -1;
		}
		if (bola.getPosition().y + 33 >= window.getSize().y || bola.getPosition().y <= 3)
		{
			//Cambiar direccion Y
			velocidad.y *= -1;
		}
		bola.move(velocidad.x, velocidad.y);
		//Update Screen
		window.clear(Color::Black);
		window.draw(bola);
		window.display();
	}
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
