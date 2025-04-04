// Tamagochi.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include "mascota.h"

using namespace std;

int main()
{
    Critter mascota;
    Critter mascota2;
    int opcion = 1;
    int jugar = 1;

    while (jugar == 1)
    {
        cout << R"(
    ooooooooooooo                                                                      oooo         o8o  
    8'   888   `8                                                                      `888         `"'  
         888       .oooo.   ooo. .oo.  .oo.    .oooo.    .oooooooo  .ooooo.   .ooooo.   888 .oo.   oooo  
         888      `P  )88b  `888P"Y88bP"Y88b  `P  )88b  888' `88b  d88' `88b d88' `"Y8  888P"Y88b  `888  
         888       .oP"888   888   888   888   .oP"888  888   888  888   888 888        888   888   888  
         888      d8(  888   888   888   888  d8(  888  `88bod8P'  888   888 888   .o8  888   888   888  
        o888o     `Y888""8o o888o o888o o888o `Y888""8o `8oooooo.  `Y8bod8P' `Y8bod8P' o888o o888o o888o 
                                                        d"     YD                                        
                                                        "Y88888P'                                        )" << endl << endl;

        cout << R"(
        __  __                  
       |  \/  | ___ _ __  _   _ 
       | |\/| |/ _ \ '_ \| | | |
       | |  | |  __/ | | | |_| |
       |_|  |_|\___|_| |_|\__,_|

_______________________________________

                   -#@@@@@@@@@%-     
                -@@-            %@-  
               @*                 -% 
              @=                   :@
1. Parlar      *+                +*
                 ++            #+ 
                   -*=+=====+=.      
                  -@*                
                -*                     


                    _.(-)._
                 .'         '.
                /             \
                |'-...___...-'|
                 \    '='    /
2. Alimentar      `'._____.'` 
                   /   |   \
                  /.--'|'--.\
               []/'-.__|__.-'\[]
                       |
                      [|]


                  _._______
                 | _______ |
                 ||,-----.||
                 |||     |||
                 |||_____|||
3. Jugar         |`-------'|
                 | +     O |
                 |      O  |
                 | / /  ##,"
                  `------"


                __       __
                \ \     / /
                 \ \   / /
                  \ \_/ /
                   \   /
4. Sortir           ) (
                   / _ \
                  / / \ \
                 / /   \ \
                /_/     \_\
)";
        cin >> opcion;

        switch (opcion)
        {
        case 1:
            mascota.Talk();
            break;
        case 2:
            mascota.Eat();
            break;
        case 3:
            mascota.Play();
            break;
        case 4:
            jugar = 0;
            break;
        default:
            cout << "Opcio no valida";
            break;
        }
    
        system("cls");
    
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
