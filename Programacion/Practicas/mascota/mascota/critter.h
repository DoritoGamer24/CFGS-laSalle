#pragma once
class critter
{
public:
	static int s_Total;
	//static member variable declaration
	//total number of Critter objects in existence
	critter(int hunger = 0);
	static int GetTotal(); //static member function prototype
private:
	int m_Hunger;
	};


