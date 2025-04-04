using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ClasseGenerica
{
    //Here is a generic method. Notice the generic
    //type 'T'. This 'T' will be replaced at runtime
    //with an actual type. 
    public T GenericMethod<T>(T param)  //La T s'haura de determinar abans d'executar la funcio perque pugui funcionar
    {
        return param;
    }
}
