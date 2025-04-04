using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ParentFruit : MonoBehaviour
{
    public string color;

    //This is the first constructor for the Fruit class
    //and is not inherited by any derived classes.
    public ParentFruit()    //Generador pare amb color predeterminat
    {
        color = "orange";
        Debug.Log("1st Fruit Constructor Called");
    }

    //This is the second constructor for the Fruit class
    //and is not inherited by any derived classes.
    public ParentFruit(string newColor) //Generador pare amb color assignat
    {
        color = newColor;
        Debug.Log("2nd Fruit Constructor Called");
    }

    public void Chop()  //Metode pare de tallar la fruita
    {
        Debug.Log("The " + color + " fruit has been chopped.");
    }

    public void SayHello()  //Metode pare de dir hola
    {
        Debug.Log("Hello, I am a fruit.");
    }
}
