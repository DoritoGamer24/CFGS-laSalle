// Prova_moduls.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include "EscriureCadena.h"
using namespace std;
double avg(double x, double y);

void main()
{
	cout << "Executant...\n";
	EscriureCadena(Meva_CADENA);
	cout << "Finalitzat.\n";

	system("PAUSE");
	system("cls");

	double a = 1.1;
	double b = 2.7;
	cout << "Avg is " << avg(a, b);
	cout << endl;
	cout << endl;

	system("PAUSE");
}

double avg(double x, double y) {
	double v = (x + y) / 2;
	return v;
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
