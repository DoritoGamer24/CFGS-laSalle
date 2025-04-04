#pragma once
#include <string>

using namespace std;

class titulars
{
public:
	titulars(string titular, int monedes, string objMagic);
private:
	string p_titular;
	int p_monedes;
	string p_objMagics{ 5 };
};

