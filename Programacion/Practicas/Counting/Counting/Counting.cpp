// Counting.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
using namespace std;

int main()
{
    cout << "Counting forwards:\n";
    int cont = 0;
    int num = 0;
    while (cont < 10)
    {
        cout << num << " ";
        ++num;
        ++cont;
    }

    cout << endl << "Counting backwards:\n";
    int count = 0;
    int i = 9;
    while (count < 10)
    {
        cout << i << " ";
        --i;
        ++count;
    }

    cout << endl << "Counting by 5:\n";
    int counter = 0;
    int n = 30;
    while (counter < 10)
    {
        cout << n << " ";
        n += 5;
        ++counter;
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
