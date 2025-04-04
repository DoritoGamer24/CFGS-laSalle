using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enumeracions : MonoBehaviour
{
    enum Direction { North, East, South, West }; //Enumeracions amb valors predeterminats 0, 1, 2, 3

    void Start()
    {
        Direction myDirection;  //Es crea una direccio que es diu myDirection per poder guardar les direccions del enum

        myDirection = Direction.North;  //En aquest es guarda la direccio nort afegint el .North endavant de Direction.
        Debug.Log(myDirection);
        myDirection = Direction.South;
        Debug.Log(myDirection);
        myDirection = ReverseDirection(Direction.East);
        Debug.Log(myDirection);
        myDirection = ReverseDirection(Direction.West);
        Debug.Log(myDirection);
    }

    Direction ReverseDirection(Direction dir)   //Els enums també poden ser utilitzats dins de funcions noves
    {
        if (dir == Direction.North)
            dir = Direction.South;
        else if (dir == Direction.South)
            dir = Direction.North;
        else if (dir == Direction.East)
            dir = Direction.West;
        else if (dir == Direction.West)
            dir = Direction.East;

        return dir; //En aquest cas el que es fa es revertir la direccio que s'ha donat per el parametre
    }
}
