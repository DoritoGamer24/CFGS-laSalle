using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UIElements;

public class m4a1 : arma
{
    private int switchCounter = 0;  // Contador para alternar entre modos de disparo
    public float tiempoEntreDisparos = 0.2f;  // Tiempo de espera entre disparos en modo autom�tico
    private bool disparando = false;  // Bandera para controlar si ya se est� disparando

    // M�todo Start que se llama al inicio
    void Start()
    {
        // Asigna valores iniciales de munici�n y tiempo de recarga para el arma
        municion = 30;
        maxMunicion = 30;
        tiempoRecarga = 4.7f;
    }

    // M�todo Update que se llama en cada frame
    void Update()
    {
        // Verifica si el jugador presion� la tecla "Shift"
        bool presionoShift = Input.GetKey(KeyCode.LeftShift) || Input.GetKey(KeyCode.RightShift);

        if (presionoShift)
        {
            // Si Shift est� presionado, usa velocidad aumentada
            velocidadGirar = ObtenerVelocidad(aumento);
        }
        else
        {
            // Si no est� presionado, usa la velocidad normal
            velocidadGirar = ObtenerVelocidad();
        }

        // Controla la rotaci�n del personaje usando la entrada vertical del jugador
        float movimientoVertical = Input.GetAxis("Vertical");
        transform.Rotate(Vector3.forward * movimientoVertical * velocidadGirar * Time.deltaTime);

        // Si el jugador presiona la tecla "LeftControl", alterna el modo de disparo (semiautom�tico o autom�tico)
        if (Input.GetKeyDown(KeyCode.LeftControl))
        {
            switchCounter++;  // Incrementa el contador para cambiar de modo
        }

        // Modo semiautom�tico (un disparo por cada vez que se presiona espacio)
        if (switchCounter % 2 == 0)
        {
            // Si el jugador presiona el espacio, dispara una bala
            if (Input.GetKeyDown(KeyCode.Space))
            {
                base.Disparar();  // Llama al m�todo de disparo de la clase base
            }
        }
        // Modo autom�tico (dispara mientras se mantiene presionado el espacio)
        else
        {
            // Si se mantiene el espacio presionado y no est� disparando, inicia la corutina de disparo
            if (Input.GetKey(KeyCode.Space) && !disparando)
            {
                StartCoroutine(DispararConPausa());  // Inicia la corutina para disparar con pausas
            }
        }

        // Si se presiona la tecla "R", llama al m�todo para recargar
        if (Input.GetKey(KeyCode.R))
        {
            Recargar();
        }
    }

    // M�todo para disparar el arma
    public override void Disparar()
    {
        // Verifica que el cargador est� listo y que haya munici�n disponible
        if (estadoActual == estadoCargador.listo && municion > 0)
        {
            // Crear un proyectil en la posici�n actual del arma
            GameObject projectileTemp = Instantiate(projectilePrefab, transform.position, transform.rotation);
            Destroy(projectileTemp, 2);  // Destruye el proyectil despu�s de 2 segundos
            municion--;  // Reduce la munici�n disponible en uno

            // Si la munici�n llega a cero, muestra el mensaje de recarga
            if (municion == 0)
            {
                textRecarga.SetActive(true);
            }
        }
        // Si el cargador est� vac�o o no hay munici�n, muestra un mensaje de error
        else if (estadoActual == estadoCargador.vacio || municion == 0)
        {
            Debug.Log("No puedes disparar, est�s recargando o no tienes munici�n...");
        }
    }

    // Corutina que permite disparar con una pausa entre disparos en modo autom�tico
    private IEnumerator DispararConPausa()
    {
        disparando = true;  // Marca que se est� disparando para evitar reinicios de la corutina

        // Mientras se mantenga el espacio presionado y haya munici�n, sigue disparando
        while (Input.GetKey(KeyCode.Space) && municion > 0)
        {
            Disparar();  // Llama al m�todo de disparo

            // Espera el tiempo especificado entre disparos antes de volver a disparar
            yield return new WaitForSeconds(tiempoEntreDisparos);
        }

        disparando = false;  // Finaliza el ciclo de disparo y marca que ya no est� disparando
    }
}