// Tasca1_Programa variable.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
using namespace std;

int main()
{
    //Exercici 1
    int peus = 0, polzades;
    polzades = 0;

    cout << "Peus: " << peus << endl;
    cout << "Polzades: " << polzades << endl;

    cout << endl << "-----------------------------\n";
    //Exercici 2
    cout << endl;

    int val1, val2, val3, val4, val5;

    //cout << val1 << val2 << val3 << val4 << val5

    //Aquest programa mostrara un error ja que no s'ha proporciant un valor per a les variables creades.

    cout << endl << "-----------------------------\n";
    //Exercici 3
    cout << endl;

    int ftemp;
    double ctemp;
    cout << "Aquest programa mostrara la conversio de Fahrenheit a Celsius.\n";
    cout << "Introdueix la temperatura en Fahrenheit: ";
    cin >> ftemp;
    ctemp = ((ftemp - 32) / 1.8);
    cout << endl << "La temperatura en Celsius es: " << ctemp;
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
