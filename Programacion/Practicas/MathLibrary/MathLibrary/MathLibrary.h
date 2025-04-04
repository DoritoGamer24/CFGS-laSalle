#pragma once // Asegura que el archivo no se incluya varias veces en la compilaci�n

#ifdef MATHLIBRARY_EXPORTS
#define MATHLIBRARY_API __declspec(dllexport) // Exporta las funciones si se est� creando la DLL
#else
#define MATHLIBRARY_API __declspec(dllimport) // Importa las funciones si se usa la DLL
#endif

// Declaraciones de funciones exportadas
extern "C" { // Evita que los nombres de las funciones sean modificados
    MATHLIBRARY_API double Sqrt(double number); // Calcula la ra�z cuadrada
    MATHLIBRARY_API int Factorial(int number);  // Calcula el factorial
}
