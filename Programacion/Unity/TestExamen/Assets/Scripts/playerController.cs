using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class playerController : MonoBehaviour
{
    public float horizontalInput;
    public float verticalInput;
    public float speed = 5.0f;
    public int topRange = 12;
    public int bottomRange = 4;
    public int sideRange = 7;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        horizontalInput = Input.GetAxis("Horizontal");
        verticalInput = Input.GetAxis("Vertical");
        Vector3 movement = new Vector3(Input.GetAxis("Horizontal"), 0, Input.GetAxis("Vertical"));
        transform.Translate(movement * speed * Time.deltaTime);

        //Limitacio de moviment horizontal
        if (transform.position.x < -sideRange)
        {
            transform.position = new Vector3(-sideRange, transform.position.y, transform.position.z);
        }

        if (transform.position.x > sideRange)
        {
            transform.position = new Vector3(sideRange, transform.position.y, transform.position.z);
        }


        //Limitacio de moviment vertical
        if (transform.position.z < bottomRange)
        {
            transform.position = new Vector3(transform.position.x, transform.position.y, bottomRange);
        }

        if (transform.position.z > topRange)
        {
            transform.position = new Vector3(transform.position.x, transform.position.y, topRange);
        }
    }
}
