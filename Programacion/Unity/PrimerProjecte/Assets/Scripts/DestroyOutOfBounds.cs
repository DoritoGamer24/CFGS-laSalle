using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DestroyOutOfBounds : MonoBehaviour
{
    private float topBound = 36;
    private float sideBound = 47;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (transform.position.z > topBound)
        {
            Destroy(gameObject);
        } 
        else if (transform.position.x == sideBound || transform.position.x == -sideBound)
        {
            Debug.Log("Game Over");
            Destroy(gameObject);
        }
    }
}
