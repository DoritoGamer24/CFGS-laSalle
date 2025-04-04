#include "Header_IQE.h"
#include <iostream>

namespace IQE
{
	int divisionNumber::numDiv(int a, int b)
	{
		if (b == 0)
		{
			std::cout << "No es pot dividir un numero entre 0. Es retornara el valor predeterminat.";
			return 0;
		}
		else
		{
			return a / b;
		}
	}
}