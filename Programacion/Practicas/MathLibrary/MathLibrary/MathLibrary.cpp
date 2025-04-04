#include "pch.h" // Solo si usas encabezados precompilados
#include "MathLibrary.h" // Archivo de cabecera con las declaraciones
#include <cmath> // Biblioteca para funciones matem�ticas avanzadas

// Calcula la ra�z cuadrada de un n�mero
double Sqrt(double number) {
    return sqrt(number); // Utiliza la funci�n est�ndar sqrt
}

// Calcula el factorial de un n�mero
int Factorial(int number) {
    int result = 1;
    for (int i = 1; i <= number; ++i) {
        result *= i; // Multiplica los n�meros desde 1 hasta 'number'
    }
    return result; // Devuelve el resultado
}
