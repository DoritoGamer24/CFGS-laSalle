#pragma once
class Critter
{
public:
	Critter(int hunger = 5, int boredom = 5);
	void Talk();
	void Eat(); 
	void Play();	

private:
	int m_Hunger;		//numero 0 = no hambre	/	10 = mucha hambre
	int m_Boredom;		//numero 0 = feliz	/	10 = aburrido
	int GetMood() const;
	void PassTime(int time);
};
