#include "critter.h"
#include <iostream>
using namespace std;

//void critter::Greet()
//{
//	cout << "Hi, I'm a Marc Jimenez Medina. My hunger level is " << m_Hunger << ".\n";
//}

int critter::s_Total = 0; 
critter::critter(int hunger) :
	m_Hunger(hunger)
{
	cout << "A critter has been born!" << endl;
	++s_Total;
}
int critter::GetTotal()
//static member function definition
{
	return s_Total;
}
