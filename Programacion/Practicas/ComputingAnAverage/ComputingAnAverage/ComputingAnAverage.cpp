// ComputingAnAverage.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
using namespace std;

int main()
{
    int listSize = 4;
    int numsProcessed = 0;
    double sum = 0;
    while (numsProcessed < listSize)
    {
        double value;
        cin >> value;
        sum += value;
        ++numsProcessed;
    }
    double average = sum / numsProcessed;
    cout << "Average: " << average << endl;
    

    const int TableSize = 20;
    int i = 0;
    long Entry = 1;

    cout << "i" << "\t\t" << "2 ** i" << endl;

    while (i < TableSize)
    {
        cout << i << "\t\t" << Entry << endl;
        Entry = 2 * Entry;
        ++i;
    }
    return 0;
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln