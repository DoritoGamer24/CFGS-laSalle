using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class seleccion : MonoBehaviour
{
    public Button Pistola;
    public Button M4A4;
    public GameObject PantallaSeleccio;
    public GameObject pistola;
    public GameObject metralleta;


    // Start is called before the first frame update
    void Start()
    {
        Pistola.onClick.AddListener(seleccionarPistola);
        M4A4.onClick.AddListener(seleccionarM4A4);
    }

    public void seleccionarPistola()
    {
        PantallaSeleccio.SetActive(false);
        pistola.SetActive(true);
    }

    public void seleccionarM4A4()
    {
        PantallaSeleccio.SetActive(false);
        metralleta.SetActive(true);
    }
}
