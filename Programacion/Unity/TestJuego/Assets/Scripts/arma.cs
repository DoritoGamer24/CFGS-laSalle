using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UIElements;

public class arma : MonoBehaviour
{
    // Enum que define el estado del cargador (vacío o listo)
    public enum estadoCargador { vacio, listo }

    // Variables configurables para la mecánica del arma
    public float tiempoRecarga = 5.5f;  // Tiempo necesario para recargar
    public int maxMunicion = 5;  // Máxima cantidad de munición
    public int municion = 5;  // Munición actual
    public GameObject Gun;  // Referencia al objeto del arma
    public estadoCargador estadoActual = estadoCargador.listo;  // Estado actual del cargador
    public float velocidadGirar;  // Velocidad de rotación
    public int velocidadNormal = 20;  // Velocidad de rotación normal
    public float aumento = 2.5f;  // Multiplicador para la velocidad aumentada
    public GameObject projectilePrefab;  // Prefab del proyectil a disparar
    public GameObject textRecarga;  // Mensaje de recarga visible al quedarse sin munición

    // Método Update que se ejecuta en cada frame para capturar la entrada del jugador
    void Update()
    {
        // Comprueba si el jugador está presionando "Shift" para ajustar la velocidad de giro
        bool presionoShift = Input.GetKey(KeyCode.LeftShift) || Input.GetKey(KeyCode.RightShift);

        if (presionoShift)
        {
            velocidadGirar = ObtenerVelocidad(aumento);  // Usa velocidad aumentada si Shift está presionado
        }
        else
        {
            velocidadGirar = ObtenerVelocidad();  // Usa la velocidad normal si Shift no está presionado
        }

        // Gira la arma basándose en el input del jugador
        float movimientoVertical = Input.GetAxis("Vertical");
        transform.Rotate(Vector3.forward * movimientoVertical * velocidadGirar * Time.deltaTime);

        // Verifica si el jugador presiona la tecla "Espacio" para disparar
        if (Input.GetKeyDown(KeyCode.Space))
        {
            Disparar();  // Llama al método de disparo
        }

        // Verifica si el jugador presiona "R" para recargar el arma
        if (Input.GetKey(KeyCode.R))
        {
            Recargar();  // Llama al método de recarga
        }
    }

    // Devuelve la velocidad normal de rotación
    public int ObtenerVelocidad()
    {
        return velocidadNormal;
    }

    // Devuelve la velocidad aumentada de rotación cuando Shift está presionado
    public float ObtenerVelocidad(float aumentado)
    {
        return velocidadNormal * aumentado;
    }

    // Método virtual para disparar el arma
    public virtual void Disparar()
    {
        // Si el estado del cargador es "vacío", no se puede disparar
        if (estadoActual == estadoCargador.vacio)
        {
            Debug.Log("No puedes disparar, estás recargando...");
            return;
        }

        // Si hay munición disponible, dispara un proyectil
        if (municion > 0)
        {
            GameObject projectileTemp = Instantiate(projectilePrefab, transform.position, transform.rotation);  // Instancia un proyectil
            Destroy(projectileTemp, 2);  // Destruye el proyectil después de 2 segundos
            municion--;  // Reduce la munición en 1
        }
        else
        {
            // Si no hay munición, muestra el texto de recarga
            textRecarga.SetActive(true);
        }
    }

    // Inicia el proceso de recarga si el cargador está listo y hay menos munición que el máximo
    public void Recargar()
    {
        if (estadoActual == estadoCargador.listo && municion < maxMunicion)
        {
            Debug.Log("Recargando...");
            StartCoroutine(RecargarCoroutine());  // Inicia la recarga con una corrutina
        }
    }

    // Corrutina que simula el proceso de recarga con un retardo
    private IEnumerator RecargarCoroutine()
    {
        estadoActual = estadoCargador.vacio;  // Cambia el estado a vacío mientras recarga
        textRecarga.SetActive(false);  // Oculta el mensaje de recarga
        yield return new WaitForSecondsRealtime(tiempoRecarga);  // Espera el tiempo de recarga
        municion = maxMunicion;  // Rellena la munición
        estadoActual = estadoCargador.listo;  // Cambia el estado a listo después de la recarga
        Debug.Log("Recarga completada");
    }
}