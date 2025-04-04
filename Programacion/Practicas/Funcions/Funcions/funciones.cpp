#include <iostream>
#include <cmath>

using namespace std;

void num_factorial()
{
	int num;
	unsigned long long fact = 1;	//Aquest numero esta asignat com a long long perque el numero pugui ser gran.
	cout << "Escriu un numero per aconseguir el seu factorial: ";
	cin >> num;		//Es pregunta el numero per aconseguir el factorial.
	for (size_t i = 2; i <= num; i++)	//Es fa un for que seguira multiplicant fins a que arrivi al mateix numero.
	{
		fact = fact * i;	//Multiplica per i, i es guarda en si mateix.
	}
	cout << fact << endl;
}

void num_primer()
{
	int num_prim, prueba, cont = 0;
	double sqrt_of_n;
	cout << "Escriu un numero per saber si es primer o no: ";
	cin >> num_prim;	//Es pregunta el numero per trobar si es primer o no.
	if (num_prim < 0)	//Es comprova si el numero es negatiu.
	{
		cout << "Aquest numeros es inferior a 0.";		
	}
	else
	{
		sqrt_of_n = sqrt(num_prim);		//S'aconsegueix l'arrel quadrada del numero.
		for (size_t i = 1; i <= sqrt_of_n; i++)		//Per optimizar el codi només es fa el for fins a l'arrel quadarada del numero.
		{
			prueba = num_prim % i;	//Es fa la proba per saber si es divisible entre els numeros.
			if (prueba == 0)	//Si dona 0 en algun moment.
			{
				cont++;		//Es crea un comptador per saber si nomes s'ha pogut dividir per 1 o si s'ha pogut dividir per mes.
			}
		}
		if (cont == 1)
		{
			cout << "El numero " << num_prim << " es un numero primer!!";	//Es comproba el comptador per saber si només té 1 indicant que nomes s'ha pogut dividir per 1.
		}
		else
		{
			cout << "El numero " << num_prim << " no es un numero primer.";	//Sino significara que s'ha pogut dividir per mes de un numero abans d'arribar a l'arrel.
		}
	}
}