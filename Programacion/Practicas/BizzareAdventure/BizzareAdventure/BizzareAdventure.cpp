// BizzareAdventure.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
using namespace std;

int main()
{
    string famMember, item, adje1, action, sensa, constru, diff, mater, adje2;
    int div = 2;
    float numConstru = 0;
    bool comprob;
    char continu = 'y'; // Assignacio de variables utilitzades

    while (continu == 'y' || continu == 'Y')    //Mentres l'usuari vulgui continuar fent histories repetira tot el codi
    {
        cout << "Please write a family member (mother, father, brother,...): ";
        cin >> famMember;

        cout << "Please write an item (keyboard, shell, book,...): ";
        cin >> item;

        cout << "Please write an adjective (strange, frightning, boring,...): ";
        cin >> adje1;

        cout << "Please write an action (running, fighting, flying,...): ";
        cin >> action;

        cout << "Please write a sensation (warm, cold, hot,...): ";
        cin >> sensa;

        cout << "Please write a positive whole number: ";
        cin >> numConstru;
        comprob = float(numConstru) > float(0);
        if (comprob)        //Comprovacio de que el numero sigui almenys positiu
        {
            cout << "Please write a type of construction (pyramids, skyscrapers, houses,...): ";
            cin >> constru;
        }
        else
        {
            cout << "You need to write a positive number!!!!!\n";
            cout << "Please write a positive whole number: ";
            cin >> numConstru;
        }
        cout << "Please write a type of construction (pyramids, skyscrapers, houses,...): ";
        cin >> constru;

        cout << "Please write a difficulty (easy, hard, extreme,...): ";
        cin >> diff;

        cout << "Please write a material (wood, steel, aluminum,...): ";
        cin >> mater;

        cout << "Please write a second adjective(strange, frightning, boring, ...) : ";
        cin >> adje2;                                                                       //Preguntes per a donar valor per entrada del usuari

        numConstru /= div;
        
        //Creacio de l'historia amb les variables entrades per l'usuari
        cout << "Your " << famMember << " left a(n) " << item << " for you after his/her death, (s)he said it could be used to get to somewhere " << adje1 << " but (s)he couldn't tell you where exactly (s)he only told you that it was on the forest close to his/her house and after some years you think you might have found what (s)he said.\n";

        cout << "After " << action << " on it for some days you decide to go looking, this went on for some months.";

        cout << "But one day when you were looking around the forest where you found the ruins of an old tower, you recognised this tower because no one knew how to open the door on the basement of it and any attempts to get in were futile.\n";

        cout << "Now you wonder if the " << item << " may fit...\n";

        cout << "You go down the old stairs and try to put in the " << item << ", it seems to fit!. Once you turn the " << item << " you notice a " << sensa << " air coming from the door and finally after opening it, you fall to a sandy floor.\n";

        cout << "Once you get yourself together and look around you, you seem to notice you are in ancient egypt. You looked around but couldn't find the door. You could only see " << numConstru << " " << constru << " one of them seems to be new or recently built but it's a lot further away.\n";

        cout << "You saw no one on the " << constru << " close by so you decided to investigate the insides, the inside seemd to be abandoned but the long and labyrinth-like hallways were " << diff << " to navigate, once you made it to the end you found a strange machine it looked like a " << mater << " tube with buttons and numbers and letters, it was a very contrasting thing since it looked pretty much new.\n";

        cout << "Once you pressed one of the many buttons a bright light consumed the room and appeared back at home, you were " << adje2 << " but wanted to look further in the future.\n";

        cout << "Do you want to create another story? (Y/N) ";      //Pregunta de si l'usuari vol continuar creant histories o no
        cin >> continu;
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
