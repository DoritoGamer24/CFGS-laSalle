using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UIElements;

public class m4a1 : arma
{
    private int switchCounter = 0;  // Contador para alternar entre modos de disparo
    public float tiempoEntreDisparos = 0.2f;  // Tiempo de espera entre disparos en modo automático
    private bool disparando = false;  // Bandera para controlar si ya se está disparando

    // Método Start que se llama al inicio
    void Start()
    {
        // Asigna valores iniciales de munición y tiempo de recarga para el arma
        municion = 30;
        maxMunicion = 30;
        tiempoRecarga = 4.7f;
    }

    // Método Update que se llama en cada frame
    void Update()
    {
        // Verifica si el jugador presionó la tecla "Shift"
        bool presionoShift = Input.GetKey(KeyCode.LeftShift) || Input.GetKey(KeyCode.RightShift);

        if (presionoShift)
        {
            // Si Shift está presionado, usa velocidad aumentada
            velocidadGirar = ObtenerVelocidad(aumento);
        }
        else
        {
            // Si no está presionado, usa la velocidad normal
            velocidadGirar = ObtenerVelocidad();
        }

        // Controla la rotación del personaje usando la entrada vertical del jugador
        float movimientoVertical = Input.GetAxis("Vertical");
        transform.Rotate(Vector3.forward * movimientoVertical * velocidadGirar * Time.deltaTime);

        // Si el jugador presiona la tecla "LeftControl", alterna el modo de disparo (semiautomático o automático)
        if (Input.GetKeyDown(KeyCode.LeftControl))
        {
            switchCounter++;  // Incrementa el contador para cambiar de modo
        }

        // Modo semiautomático (un disparo por cada vez que se presiona espacio)
        if (switchCounter % 2 == 0)
        {
            // Si el jugador presiona el espacio, dispara una bala
            if (Input.GetKeyDown(KeyCode.Space))
            {
                base.Disparar();  // Llama al método de disparo de la clase base
            }
        }
        // Modo automático (dispara mientras se mantiene presionado el espacio)
        else
        {
            // Si se mantiene el espacio presionado y no está disparando, inicia la corutina de disparo
            if (Input.GetKey(KeyCode.Space) && !disparando)
            {
                StartCoroutine(DispararConPausa());  // Inicia la corutina para disparar con pausas
            }
        }

        // Si se presiona la tecla "R", llama al método para recargar
        if (Input.GetKey(KeyCode.R))
        {
            Recargar();
        }
    }

    // Método para disparar el arma
    public override void Disparar()
    {
        // Verifica que el cargador esté listo y que haya munición disponible
        if (estadoActual == estadoCargador.listo && municion > 0)
        {
            // Crear un proyectil en la posición actual del arma
            GameObject projectileTemp = Instantiate(projectilePrefab, transform.position, transform.rotation);
            Destroy(projectileTemp, 2);  // Destruye el proyectil después de 2 segundos
            municion--;  // Reduce la munición disponible en uno

            // Si la munición llega a cero, muestra el mensaje de recarga
            if (municion == 0)
            {
                textRecarga.SetActive(true);
            }
        }
        // Si el cargador está vacío o no hay munición, muestra un mensaje de error
        else if (estadoActual == estadoCargador.vacio || municion == 0)
        {
            Debug.Log("No puedes disparar, estás recargando o no tienes munición...");
        }
    }

    // Corutina que permite disparar con una pausa entre disparos en modo automático
    private IEnumerator DispararConPausa()
    {
        disparando = true;  // Marca que se está disparando para evitar reinicios de la corutina

        // Mientras se mantenga el espacio presionado y haya munición, sigue disparando
        while (Input.GetKey(KeyCode.Space) && municion > 0)
        {
            Disparar();  // Llama al método de disparo

            // Espera el tiempo especificado entre disparos antes de volver a disparar
            yield return new WaitForSeconds(tiempoEntreDisparos);
        }

        disparando = false;  // Finaliza el ciclo de disparo y marca que ya no está disparando
    }
}