using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pistola : arma
{
    // Configura munici�n y tiempo de recarga al inicio
    void Start()
    {
        municion = 15;  // Munici�n inicial
        maxMunicion = 15;  // Capacidad m�xima
        tiempoRecarga = 3.7f;  // Tiempo de recarga
    }

    // L�gica que se ejecuta en cada frame
    void Update()
    {
        // Comprueba si se est� presionando "Shift" para ajustar la velocidad de giro
        bool presionoShift = Input.GetKey(KeyCode.LeftShift) || Input.GetKey(KeyCode.RightShift);

        if (presionoShift)
        {
            velocidadGirar = ObtenerVelocidad(aumento);  // Aumenta velocidad si se presiona Shift
        }
        else
        {
            velocidadGirar = ObtenerVelocidad();  // Usa velocidad normal si no
        }

        // Gira el personaje seg�n el input vertical
        float movimientoVertical = Input.GetAxis("Vertical");
        transform.Rotate(Vector3.forward * movimientoVertical * velocidadGirar * Time.deltaTime);

        // Dispara al presionar "Espacio"
        if (Input.GetKeyDown(KeyCode.Space))
        {
            Disparar();  // Llama a la funci�n de disparo
        }

        // Recarga al presionar "R"
        if (Input.GetKey(KeyCode.R))
        {
            Recargar();  // Llama a la funci�n de recarga
        }
    }
}
