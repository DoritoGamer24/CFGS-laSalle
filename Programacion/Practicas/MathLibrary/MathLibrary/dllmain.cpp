#include "pch.h" // Incluido si usas encabezados precompilados
#include <windows.h> // API de Windows para manejar la DLL

BOOL APIENTRY DllMain(HMODULE hModule,
    DWORD  ul_reason_for_call,
    LPVOID lpReserved) {
    switch (ul_reason_for_call) {
    case DLL_PROCESS_ATTACH: // Cuando un proceso carga la DLL
    case DLL_THREAD_ATTACH:  // Cuando un hilo carga la DLL
    case DLL_THREAD_DETACH:  // Cuando un hilo descarga la DLL
    case DLL_PROCESS_DETACH: // Cuando un proceso descarga la DLL
        break;
    }
    return TRUE; // La DLL se carga correctamente
}
