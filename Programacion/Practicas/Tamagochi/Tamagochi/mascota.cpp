#include "mascota.h"
#include <iostream>
#include <math.h>

using namespace std;

Critter::Critter(int hunger, int boredom) :
	m_Hunger(hunger), m_Boredom(boredom)
{
	cout << "Hola, soc la teva mascota. La meva fam es de " << m_Hunger << " i ara mateix tinc un nivell d'aburriment de " << m_Boredom << endl;
}

void Critter::Talk()
{
	system("cls");
	int mood = GetMood();
	if (mood <= 5)
	{
		cout << "Estic perfectament :D";
	}
	else if (mood <= 10)
	{
		cout << "Em trobo bastant be :3";
	}
	else if (mood <= 15)
	{
		cout << "No em trobo del tot be :/";
	}
	else
	{
		cout << "Em trobo molt malament, fes alguna cosa :C";
	}
	PassTime(1);
	system("pause");
}

void Critter::Eat()
{
	system("cls");
	int opcio;
	cout << R"(
    __  __                  
   |  \/  | ___ _ __  _   _ 
   | |\/| |/ _ \ '_ \| | | |
   | |  | |  __/ | | | |_| |
   |_|  |_|\___|_| |_|\__,_|

________________________________

                 ,--./,-.
                / #      \
1. Poma        |          |
                \        / 
                 `._,._,'

              // ""--.._
             ||  (_)  _ "-._
2. Pizza     ||    _ (_)    '-.
             ||   (_)   __..-'
              \\__..--""

                     (
                      )
                 __..---..__
             ,-='  /  |  \  `=-.
3. Pastis   :--..___________..--;
             \.,_____________,./
)";

	cout << "Escull una dels jocs: ";
	cin >> opcio;

	if (m_Hunger > 0)
	{
		switch (opcio)
		{
		case 1:
			m_Hunger -= 2;
			PassTime(1);
			break;
		case 2:
			m_Hunger -= 3;
			PassTime(1);
			break;
		case 3:
			m_Hunger -= 5;
			PassTime(2);
			break;
		default:
			cout << "Opcio no valida";
			break;
		}
	}
	else
	{
		cout << "No tinc gana";
	}
	system("pause");
}

void Critter::Play()
{
	system("cls");
	int opcio;
	int numero = (rand() * 5) + 1;
	int numero2 = (rand() * 5) + 1;

	cout << R"(
          __  __                  
         |  \/  | ___ _ __  _   _ 
         | |\/| |/ _ \ '_ \| | | |
         | |  | |  __/ | | | |_| |
         |_|  |_|\___|_| |_|\__,_|

_______________________________________________
                   _____
                  |A .  | _____
                  | /.\ ||A ^  | _____
                  |(_._)|| / \ ||A _  | _____
                  |  |  || \ / || ( ) ||A_ _ |
1. Cartes         |____V||  .  ||(_'_)||( v )|
                         |____V||  |  || \ / |
                                |____V||  .  |
                                       |____V|

                            ___
                        .:::---:::.
                      .'--:     :--'.
                     /.'   \   /   `.\
                    | /'._ /:::\ _.'\ |
2. Pilota           |/    |:::::|    \|
                    |:\ .''-:::-''. /:|
                     \:|    `|`    |:/
                      '.'._.:::._.'.'
                        '-:::::::-'

                      _  __________=__
                      \\@([____]_____()
                     _/\|-[____]
3. Ruleta rusa       /     /(( )
                    /____|'----'
                    \____/
)";

	cout << "Escull una dels jocs: ";
	cin >> opcio;

	if (m_Boredom > 0)
	{
		switch (opcio)
		{
		case 1:
			m_Boredom -= 2;
			PassTime(1);
			break;
		case 2:
			m_Boredom -= 5;
			PassTime(2);
			break;
		case 3:
			if (numero != numero2)
			{
				m_Boredom -= 10;
				PassTime(1);
			}
			else
			{
				cout << "Se ta muerto";
				system("pause");
			}
			break;
		default:
			cout << "Opcio no valida";
			break;
		}
	}
	else
	{
		cout << "No tinc ganes de jugar";
		PassTime(1);
	}
	system("pause");
}

int Critter::GetMood()const
{
	int mood = m_Hunger + m_Boredom;
	return mood;
}

void Critter::PassTime(int time)
{
	m_Hunger += 1 * time;
	m_Boredom += 1 * time;
}
