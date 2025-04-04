#pragma once // Asegura que el archivo no se incluya varias veces en la compilación

#ifdef MATHLIBRARY_EXPORTS
#define MATHLIBRARY_API __declspec(dllexport) // Exporta las funciones si se está creando la DLL
#else
#define MATHLIBRARY_API __declspec(dllimport) // Importa las funciones si se usa la DLL
#endif

// Declaraciones de funciones exportadas
extern "C" { // Evita que los nombres de las funciones sean modificados
    MATHLIBRARY_API double Sqrt(double number); // Calcula la raíz cuadrada
    MATHLIBRARY_API int Factorial(int number);  // Calcula el factorial
}
