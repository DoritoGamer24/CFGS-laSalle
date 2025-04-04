using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pistola : arma
{
    // Configura munición y tiempo de recarga al inicio
    void Start()
    {
        municion = 15;  // Munición inicial
        maxMunicion = 15;  // Capacidad máxima
        tiempoRecarga = 3.7f;  // Tiempo de recarga
    }

    // Lógica que se ejecuta en cada frame
    void Update()
    {
        // Comprueba si se está presionando "Shift" para ajustar la velocidad de giro
        bool presionoShift = Input.GetKey(KeyCode.LeftShift) || Input.GetKey(KeyCode.RightShift);

        if (presionoShift)
        {
            velocidadGirar = ObtenerVelocidad(aumento);  // Aumenta velocidad si se presiona Shift
        }
        else
        {
            velocidadGirar = ObtenerVelocidad();  // Usa velocidad normal si no
        }

        // Gira el personaje según el input vertical
        float movimientoVertical = Input.GetAxis("Vertical");
        transform.Rotate(Vector3.forward * movimientoVertical * velocidadGirar * Time.deltaTime);

        // Dispara al presionar "Espacio"
        if (Input.GetKeyDown(KeyCode.Space))
        {
            Disparar();  // Llama a la función de disparo
        }

        // Recarga al presionar "R"
        if (Input.GetKey(KeyCode.R))
        {
            Recargar();  // Llama a la función de recarga
        }
    }
}
