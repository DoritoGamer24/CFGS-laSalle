// EscriuIDepura.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
using namespace std;

int main()
{
    //Ex1
    int edad;   //Creacio de variable
    cout << "Quina es la teva edad? ";
    cin >> edad;    //Es posa valor a la variable creada
    bool comprobar = edad > 17; //Creacio de variable bool per a fer la comparacio

    if (comprobar) {
        cout << "Ets major d'edad!\n";  //Si la variable que te la comparacio indica que es certa mostrara aquest text
    }

    else {
        cout << "Ets menor d'edad.\n";  //Sino mostrara aquest altre
    }

    //Ex2
    int num;
    int opera;  //Creacio de variables

    cout << "Escriu un nombre per comprobar si es par o no: ";
    cin >> num; //Es pregunta el valor de num per despres fer l'operacio i saber si es par o impar
    opera = num % 2;    //Operacio utilitzada per saber si es par o no
    if (opera == 0) {
        cout << "El numero es par.\n";  //Si lo operacio retorna 0 significa que es par
    }

    else {
        cout << "El numero es impar.\n";    //Si al contrari retorna un altre numero sera impar
    }

    //Ex3
    int mult;
    int comparar;   //Creacio de variables utilitzades per a entrada o guardar numeros
    int contador = 0;   //Creacio d'un comptador per determinar quants numeros falten per ser multiple de 7

    cout << "Escriu un nombre per comprobar si es multiple de 7 o no: ";
    cin >> mult;    //Es demana el numero a comprovar
    comparar = mult % 7;    //Es guarda el reste per a saber si es multpiple o no

    if (comparar == 0)
    {
        cout << "El numero es multiple de 7.\n";    //Si es multiple mostrara aquest text
    }

    else
    {
        while (comparar != 0) {     //Sino fara aquest bucle
            ++mult;                 //Que sumara a mult per tal de utilitzar-ho com a comptador
            comparar = mult % 7;
            ++contador;             //Seguidament el comptador anira sumant per tal de saber quant faltava per a ser multiple
        }
        cout << "Et faltaven sumar " << contador << " per a aconseguir un multiple de 7.\n";
    }

    //Ex4
    int segs;
    int mins;
    int horas;  //Creacio de variables

    cout << "Escriu quants segons has estat jugant: ";
    cin >> segs;        //Es demana els segons que has estat jugant
    mins = segs / 60;   //Es divideix per 60 per aconseguir els minuts
    horas = mins / 60;  //Els minuts es divideixen per 60 per aconseguir les hores
    cout << "Portes jugant " << segs << " segons o " << mins << " minuts o " << horas << " hores\n"; //Finalment es mostra per pantalla cuants segons, minuts i hores has jugat

    //Ex5
    int punt1;
    int punt2;  //Creacio de variables de puntuacio

    cout << "Escriu la puntuacio de jugador 1: ";
    cin >> punt1;   //S'especifica la puntuacio del jugador 1
    cout << "Escriu la puntuacio de jugador 2: ";
    cin >> punt2;   //S'especifica la puntuacio del jugador 2

    if (punt1 > punt2)  //Es compara per saber si punt1 es major que punt2
    {
        cout << punt1 << " es major que " << punt2 << endl;
    }

    else if (punt1 == punt2)    //Per saber si les puntuacions son iguals
    {
        cout << "Les puntuacions son iguals\n";
    }

    else        //Per ultim que fara si punt1 es menor que punt2
    {
        cout << punt1 << " es menor que " << punt2 << endl;
    }

    //Ex6
    int score;  //Creacio de la variable amb la posicio en la que et situes

    cout << "Escriu la posicio en la que et situas: ";
    cin >> score;   //Es demana per pantalla

    if (score <= 10)    //Es compara per saber si esta en Top 10
    {
        cout << "Estat en el Top 10\n";
    }

    else if (score <= 100)  //Es compara per saber si esta en Top 100
    {
        cout << "Estat en el Top 100\n";
    }

    else //Es compara per saber si esta en fora del Top 100
    {
        cout << "Estat fora dels Top 100 :C\n";
    }

    //Ex7
    int dni;    //Guardes el dni com a numeros per utilitzar en l'operacio
    string lletra;  //La lletra es guarda com a text la lletra introduida per l'usuari per despres comparar
    int posLetra;   //Variable que guardara posicio de la lletra en la llista
    char letras[] = { 'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E' };    //Llista de lletres possibles
    string lletreCorrect;   //La lletra correca, extreta de la llista

    cout << "Escriu el teu DNI sense la lletra: ";
    cin >> dni;     //Es demana el dni

    cout << "Escriu la lletra del DNI: ";
    cin >> lletra;  //Es demana la lletra, sigui correcta o no

    posLetra = dni % 23;    //Operacio utilitzada per extreure la posicio
    lletreCorrect = letras[posLetra];   //Extraccio de la lletra de la llista creada anteriorment

    if (lletra == lletreCorrect)        //Comparacio de la lletra
    {
        cout << "La lletra es la correcta.\n";      //Si es correcta
    }

    else
    {
        cout << "La lletra es incorrecte, la lletra correcte es " << lletreCorrect << endl; //Sino mostrara la lletra correcta del DNI
    }

    //Ex8
    string jugar = "y"; //Creacio de la variable per jugar de nou
    int diff;   //Creacio variable dificultat

    cout << "|==================|\n";     //Menu
    cout << "|--- DIFICULTAT ---|\n";
    cout << "|==================|\n";
    cout << "|     1- Facil     |\n";
    cout << "|------------------|\n";
    cout << "|     2- Mitja     |\n";
    cout << "|------------------|\n";
    cout << "|    3- Dificil    |\n";
    cout << "|==================|\n";

    while (jugar != "n" || "N")    //Mentres jugar sigui diferent de n continuara repetint el codi
    {
        cout << "Quina dificultat vol seleccionar? ";
        cin >> diff;            //Seleccio de dificultat

        if (diff == 1)      //Dificultat facil
        {
            cout << "Has escollit la dificultat facil.\n";
        }

        else if (diff == 2) //Dificultat mitjana
        {
            cout << "Has escollit la dificultat mitja.\n";
        }

        else if (diff == 3) //Dificultat dificil
        {
            cout << "Has escollit la dificultat dificil.\n";
        }

        else            //Si escriu un altre numero sortira que es invalid la opcio
        {
            cout << "Aquesta no es una opcio valida.\n";
        }

        cout << "Vols tornar a jugar? y/n: ";
        cin >> jugar;       //Preguntar si tornar a jugar (Case sensitive)

        if (jugar != "n")       //Si no introdueixen la n tornara a mostrar el codi i tornara adalt
        {
            cout << "|==================|\n";
            cout << "|--- DIFICULTAT ---|\n";
            cout << "|==================|\n";
            cout << "|     1- Facil     |\n";
            cout << "|------------------|\n";
            cout << "|     2- Mitja     |\n";
            cout << "|------------------|\n";
            cout << "|    3- Dificil    |\n";
            cout << "|==================|\n";
        }

        else                //Si la lletra es n entrara i llavors sortira
        {
            break;
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
