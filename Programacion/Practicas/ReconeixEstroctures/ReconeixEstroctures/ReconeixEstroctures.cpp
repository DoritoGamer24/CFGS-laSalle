// ReconeixEstroctures.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream> //Listat de llibreries utilitzades
using namespace std;

int main() //Codi principal
{
    //Ex1
    int edad;
    int anys = 0; //Assignacio de variables

    cout << "Quina es la teva edad? ";
    cin >> edad;  //Pregunta per a posar valor a la variable edad

    while (edad < 16) //While utilitzat per aconseguir els anys que falten
    {
        ++edad;
        anys += 1;
    }

    cout << endl << "Podras entrar a instagram dintre de " << anys << endl; //Mostra de cuants anys falten pels 16 anys i termini del primer exercici

    //---------------------------------------------------------------------------------------

    //Ex2
    int anyAct;
    int anyNaix;
    int edadAct; //Assignacio de variables

    cout << endl << "Indica en quina any ens trobem: ";
    cin >> anyAct; //Pregunta per a posar valor a la variable anyAct

    cout << endl << "Indica en quina any vas neixer: ";
    cin >> anyNaix; //Pregunta per a posar valor a la variable anyNaix

    edadAct = anyAct - anyNaix; //Calcul per aconseguir la edad actual del usuari

    cout << endl << "La teva edad es de " << edadAct << " anys."; //Mostra de l'edad actual del usuari i termini del segon exercici

    return 0; //Terminacio del programa
}



// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
