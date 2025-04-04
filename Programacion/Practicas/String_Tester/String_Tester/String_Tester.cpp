// String_Tester.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
using namespace std;

int main()
{
    string frase1, frase2, frase3, fraseCompl, frase4;
    char letra;
    int contador = 0; //Iniciacio de string per a text, char per cada caracter i int per comptador

    cout << "Escriu la primera paraula de la frase: ";
    cin >> frase1;  //Pregunta de frase1
    cout << "Escriu la segona paraula de la frase: ";
    cin >> frase2;  //Pregunta de frase2
    cout << "Escriu la ultima paraula de la frase: ";
    cin >> frase3;  //Pregunta de frase3

    fraseCompl = frase1 + " " +  frase2 + " " + frase3; //Creacio de la frase completa sumant strings

    int len = fraseCompl.length();  //Conservacio de la llargada de la frase
    while (contador < len)
    {
        letra = fraseCompl[contador];   //Es troba el caracter de la posicio donada per contador
        cout << "En la posicio " << contador << " es troba la lletra: " << letra << endl;   //Es mostra
        ++contador; //Es suma per poder buscar el seguent caracter
    }

    cout << "Escriu una paraula que buscar en la frase: ";
    cin >> frase4;  //Preguntar la frase4 que s'ha de buscar
    if (fraseCompl.find(frase4) > len)  //Utilitzacio de .find per buscar la paraula y si el valor es mayor al len (dona error) diu que no la troba
    {
        cout << "Paraula no trobada en la frase.\n";
    }
    else    //Si la frase es valida llavors et diu en quina posicio l'ha trobat
    {
        cout << "Aquesta paraula es troba en la posicio: " << fraseCompl.find(frase4) << endl;
    }

    while (contador > 0)    //Comptador utilitzat a la reversa per eliminar poc a poc la frase
    {
        fraseCompl.erase(contador);
        cout << "La frase es: " << fraseCompl << endl;
        --contador;
    }
    cout << "La frase s'ha eliminat";       //Mostrar que s'ha eliminat per complet
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
