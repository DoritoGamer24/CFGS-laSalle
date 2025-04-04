#pragma once
#include <string>

class Critter
{
public:
	Critter(const string& name = "", int age = 0);
	~Critter();
	Critter(const Critter& c);
	Critter& Critter::operator=(const Critter& c); //overloaded assignment op
	void Greet() const;

private:

	string* m_pName;
	int m_Age;

};