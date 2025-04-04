// Tasca1.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
using namespace std;

int main()
{
    int score;
    float distance;
    char playAgain = 'y';
    int lives;
    int alienKills;
    float engineTemp;
    int fuel;
    int bonus;

    score = 0;
    distance = 1628.4;
    lives = 3;
    alienKills = 10;
    engineTemp = 136.5;
    bonus = 10;

    cout << "Score: " << score << endl;
    cout << "Distance: " << distance << endl;
    cout << "Play Again? " << playAgain << endl;
    cout << endl << "Lives: " << lives << endl;
    cout << "Aliens Killed: " << alienKills << endl;
    cout << "Engine Temperature: " << engineTemp << endl;
    cout << "How much fuel? ";
    cin >> fuel;
    cout << "Fuel: " << fuel << endl;
    cout << "Bonus: " << bonus;

}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
