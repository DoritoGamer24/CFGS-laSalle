using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class arma : MonoBehaviour
{
    enum estadoCargador { vacio, lleno }
    public int maxMunicion = 5;
    public int municion = 5;
    public float velocidadGirar;
    public float tiempoRecarga = 0.2f;
    public int velocidadNormal = 20;
    public float aumento = 1.5f;
    public GameObject Gun;
    public GameObject projectilePrefab;
    public GameObject textRecarga;

    void Update()
    {
        // Verifica si el jugador presionó la tecla "Shift"
        bool presionoShift = Input.GetKey(KeyCode.LeftShift) || Input.GetKey(KeyCode.RightShift);

        if (presionoShift)
        {
            velocidadGirar = ObtenerVelocidad(aumento); // Si Shift está presionado, usa velocidad aumentada
        }
        else
        {
            velocidadGirar = ObtenerVelocidad(); // Si no, usa la velocidad normal
        }

        // Mover al personaje con la velocidad seleccionada
        float movimientoVertical = Input.GetAxis("Vertical");
        transform.Rotate(Vector3.forward * -movimientoVertical * velocidadGirar * Time.deltaTime);
        if (Input.GetKeyDown(KeyCode.Space))
        {
            Disparar();
        }

        if (Input.GetKey(KeyCode.R))
        {
            Recargar();
        }
    }
    public int ObtenerVelocidad()
    {
        return velocidadNormal;
    }

    public float ObtenerVelocidad(float aumentado)
    {
        return velocidadNormal * aumentado;
    }

    public void Disparar()
    {
        if (municion > 0)    //Si es prem Espai dispara un projectil
        {
            //Launch projectile from player
            GameObject projectileTemp = Instantiate(projectilePrefab, transform.position, transform.rotation);
            Destroy(projectileTemp, 2);
            municion--;
        }
        else
        {
            textRecarga.SetActive(true);
        }
    }

    public void Recargar()
    {
        textRecarga.SetActive(false);
        StartCoroutine(ReloadRoutine());
    }

    IEnumerator ReloadRoutine()
    {
        yield return new WaitForSeconds(tiempoRecarga);
        municion = maxMunicion;
    }
}
