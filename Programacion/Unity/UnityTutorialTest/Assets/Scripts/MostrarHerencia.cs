using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MostrarHerencia : MonoBehaviour
{
    void Start()
    {
        //Let's illustrate inheritance with the 
        //default constructors.
        Debug.Log("Creating the fruit");
        ParentFruit myFruit = new ParentFruit();
        Debug.Log("Creating the apple");
        ChildApple myApple = new ChildApple();

        //Call the methods of the Fruit class.
        myFruit.SayHello();
        myFruit.Chop();

        //Call the methods of the Apple class.
        //Notice how class Apple has access to all
        //of the public methods of class Fruit.
        myApple.SayHello();
        myApple.Chop();

        //Now let's illustrate inheritance with the 
        //constructors that read in a string.
        Debug.Log("Creating the fruit");
        myFruit = new ParentFruit("yellow");
        Debug.Log("Creating the apple");
        myApple = new ChildApple("green");

        //Call the methods of the Fruit class.
        myFruit.SayHello();
        myFruit.Chop();

        //Call the methods of the Apple class.
        //Notice how class Apple has access to all
        //of the public methods of class Fruit.
        myApple.SayHello();
        myApple.Chop();
    }
}
