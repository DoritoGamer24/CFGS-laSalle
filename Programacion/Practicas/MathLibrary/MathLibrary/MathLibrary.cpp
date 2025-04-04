#include "pch.h" // Solo si usas encabezados precompilados
#include "MathLibrary.h" // Archivo de cabecera con las declaraciones
#include <cmath> // Biblioteca para funciones matemáticas avanzadas

// Calcula la raíz cuadrada de un número
double Sqrt(double number) {
    return sqrt(number); // Utiliza la función estándar sqrt
}

// Calcula el factorial de un número
int Factorial(int number) {
    int result = 1;
    for (int i = 1; i <= number; ++i) {
        result *= i; // Multiplica los números desde 1 hasta 'number'
    }
    return result; // Devuelve el resultado
}
