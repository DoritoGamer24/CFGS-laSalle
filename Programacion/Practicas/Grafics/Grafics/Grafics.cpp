// Grafics.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include <SFML/Graphics.hpp>
using namespace sf;

int main()
{
	float velSeg, velMin, velHora;	//Variables per la velocitat
	RenderWindow window(VideoMode(1000, 1000), "Animation");	//Mida de la pantalla que s'obre
	window.setFramerateLimit(60);	//Framerate de la pantalla que es mostra

	RectangleShape seg(Vector2f(10, -480));	//Rectangle que indicara els segons
	seg.setFillColor(Color::Red);	//Color de la figura
	seg.setOrigin(Vector2f(5, -25));	//Posicio del punt d'origen
	seg.setPosition(Vector2f(500, 500));	//Posicio del rectangle

	RectangleShape minut(Vector2f(14, -450));	//Rectangle que indicara els minuts
	minut.setFillColor(Color(60, 60, 60));	//Color de la figura
	minut.setOrigin(Vector2f(7, -25));	//Posicio del punt d'origen
	minut.setPosition(Vector2f(500, 500));	//Posicio del rectangle

	RectangleShape hora(Vector2f(20, -300));	//Rectangle que indicara les hores
	hora.setFillColor(Color(40, 40, 40));	//Color de la figura
	hora.setOrigin(Vector2f(10, -25));	//Posicio del punt d'origen
	hora.setPosition(Vector2f(500, 500));	//Posicio del rectangle

	CircleShape centro;
	centro.setRadius(17);	//Radi del cercle creat
	centro.setFillColor(Color(125, 125, 125));	//Color de la figura
	centro.setOrigin(Vector2f(17, 17));	//Posicio del punt d'origen
	centro.setPosition(Vector2f(500, 500));	//Posicio del cercle

	CircleShape relog;
	relog.setRadius(480);	//Radi de la vora del rellotge
	relog.setFillColor(Color::Transparent);	//Color de la figura
	relog.setOutlineThickness(15);	//Com de gran sera la vora del cercle
	relog.setOutlineColor(Color::Black);	//Color de la vora de la figura
	relog.setOrigin(Vector2f(480, 480));	//Posicio del punt d'origen
	relog.setPosition(Vector2f(500, 500));	//Posicio del cercle que creara la vora

	Texture relogTexture;
	relogTexture.loadFromFile("./texture/reloj.jpeg");	//Textura del fons
	Sprite reloj;
	reloj.setTexture(relogTexture);	//S'aplica la textura al sprite reloj
	reloj.setPosition(-45, -45);	//Es posiciona per que estigui centrat

	velSeg = 0.11;	//Velocitat a la que gira el rectangle dels segons
	velMin = velSeg / 60;	//Velocitat dels minuts
	velHora = velMin / 12.15;	//Velocitat de les hores

	while (window.isOpen())
	{
		seg.rotate(velSeg);	//Rotar seg a la velocitat anteriorment seleccionat
		minut.rotate(velMin);	//Rotar minut a la velocitat anteriorment seleccionat
		hora.rotate(velHora);	//Rotar hora a la velocitat anteriorment seleccionat

		window.clear(Color::White);	//Fons de color blanc
		window.draw(reloj);	//Es dibuixen les figures
		window.draw(relog);
		window.draw(hora);
		window.draw(minut);
		window.draw(seg);
		window.draw(centro);
		window.display();	//Es mostren per pantalla
	}
	return 0;		//Es tenca el programa
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
