// GuessNumber.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{
	srand(time(NULL));
	int guess, tries = 1, random = rand() % 101;	//iniciacio de variables
	
	while (true)	//while que es trencara amb un break
	{
		cout << "Guess the random number between 0-100: ";
		cin >> guess;	//asignacio de numero per entrada del usuari
		if (guess > random)		//si el guess es major que el numero random asignat mostrara que es major
		{
			cout << "Too high!\n";
			++tries;		//suma 1 als intents
		}
		else if (guess < random)	//si el guess es menor que el numero random asignat mostrara que es menor
		{
			cout << "Too low!\n";
			++tries;	//suma 1 als intents
		}
		else
		{
			cout << "You got it in " << tries << " guesses!\n";		//si s'acerta el numero mostrara en quants intents ho ha completat el usuari
			break;		//llavors despres fara un break
		}
	}

	cout << "Ara ho fara l'ordinador...\n";
	int numguess, triesrob = 1, ini = 0, finnum = 101;
	int randomcomp = ini + rand() % finnum;
	string resp;
	cout << "Insert the number that the computer has to guess: ";
	cin >> numguess;

	while (true)
	{
		cout << "Guessing a random number between 0-100: ";
		cout << randomcomp << endl;
		if (randomcomp == numguess)
		{
			cout << "The computer got it in " << triesrob << " guesses!";
			break;
		}
		cout << "El numero mostrat es mes.. (GRAN/PETIT)";
		cin >> resp;
		if (resp == "petit" || "PETIT")
		{
			ini = randomcomp;
			++triesrob;
			randomcomp = ini + rand() % finnum;
		}
		else if (resp == "gran" || "GRAN")
		{
			finnum = randomcomp - 1;
			++triesrob;
			randomcomp = ini + rand() % finnum;
		}
		else
		{
			cout << "Opcio no valida.";
		}
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
