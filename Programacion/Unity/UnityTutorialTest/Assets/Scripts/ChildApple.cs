using System.Collections;
using System.Collections.Generic;
using System.Drawing;
using UnityEngine;

public class ChildApple : ParentFruit
{
    new string color;
    //This is the first constructor for the Apple class.
    //It calls the parent constructor immediately, even
    //before it runs.
    public ChildApple()
    {
        //Notice how Apple has access to the public variable
        //color, which is a part of the parent Fruit class.
        color = "red";
        Debug.Log("1st Apple Constructor Called");  //Constructor amb polimorfisme per que estigui relacionat amb la fruita utilitzada
    }

    //This is the second constructor for the Apple class.
    //It specifies which parent constructor will be called
    //using the "base" keyword.
    public ChildApple(string newColor)
    {
        //Notice how this constructor doesn't set the color
        //since the base constructor sets the color that
        //is passed as an argument.
        color = newColor;
        Debug.Log("2nd Apple Constructor Called");  //Constructor amb polimorfisme per que estigui relacionat amb la fruita utilitzada
    }

    public new void Chop()
    {
        Debug.Log("The " + color + " apple has been chopped.");
    }

    public new virtual void SayHello()
    {
        Debug.Log("Hello, I am an apple.");
    }
}
