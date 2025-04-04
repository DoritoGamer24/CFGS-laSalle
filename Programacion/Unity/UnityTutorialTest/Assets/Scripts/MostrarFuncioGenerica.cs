using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using static Sobrecarrega;

public class MostrarFuncioGenerica : MonoBehaviour
{
    void Start()
    {
        ClasseGenerica myClass = new ClasseGenerica(); //Es guarda la classe del metode generic com a un de nou

        //In order to use this method you must
        //tell the method what type to replace
        //'T' with.
        Debug.Log(myClass.GenericMethod<int>(5));  //S'utilitza aquesta classe guardada per fer us del metode generic.
    }
}
