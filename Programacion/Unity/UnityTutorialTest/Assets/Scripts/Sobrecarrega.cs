using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Sobrecarrega : MonoBehaviour
{
    public class SomeClass
    {
        //The first Add method has a signature of
        //"Add(int, int)". This signature must be unique.
        public int Add(int num1, int num2)  //Funcio per sumar numeros
        {
            return num1 + num2;
        }

        //The second Add method has a sugnature of
        //"Add(string, string)". Again, this must be unique.
        public string Add(string str1, string str2) //Funcio per sumar textos
        {
            return str1 + str2;
        }
    }
}
