using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    private Rigidbody playerRb;
    public float speed = 3.0f;
    private GameObject focalPoint;
    public GameObject projectilePrefab;
    // Start is called before the first frame update
    void Start()
    {
        playerRb = GetComponent<Rigidbody>();
        focalPoint = GameObject.Find("focal Point");
        
    }

    // Update is called once per frame
    void Update()
    {
        float forwardInput = Input.GetAxis("Vertical");
        playerRb.AddForce(focalPoint.transform.forward * speed * forwardInput);

        if (Input.GetKeyDown(KeyCode.Space) && hasGun == true)    //Si es prem Espai dispara un projectil
        {
            //Launch projectile from player
            GameObject projectileTemp = Instantiate(projectilePrefab, transform.position, focalPoint.transform.rotation);
            Destroy(projectileTemp, 2);
        }
    }

    public bool hasPowerup;
    public bool hasGun;

    private void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Powerup"))
        {
            hasPowerup = true;
            Destroy(other.gameObject);
            StartCoroutine(PowerupCountdownRoutine());
        }

        if (other.CompareTag("Gun"))
        {
            hasGun = true;
            Destroy(other.gameObject);
            StartCoroutine(GunCountdownRoutine());
        }
    }

    IEnumerator PowerupCountdownRoutine() 
    { 
        yield return new WaitForSeconds(7); 
        hasPowerup = false; 
    }

    IEnumerator GunCountdownRoutine()
    {
        yield return new WaitForSeconds(4);
        hasGun = false;
    }

    private float powerupStrength = 15.0f;
    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.CompareTag("Enemy") && hasPowerup) 
        { 
            Rigidbody enemyRigidbody = collision.gameObject.GetComponent<Rigidbody>(); 
            Vector3 awayFromPlayer = (collision.gameObject.transform.position - transform.position); 
            Debug.Log("Player collided with " + collision.gameObject + " with powerup set to " + hasPowerup); 
            enemyRigidbody.AddForce(awayFromPlayer * powerupStrength, ForceMode.Impulse); 
        }
    }
}
