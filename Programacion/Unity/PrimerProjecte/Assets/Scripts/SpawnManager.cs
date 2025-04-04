using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnManager : MonoBehaviour
{
    public GameObject[] animalPrefabs;
    private float spawnRangeZ = 17;
    private int spawnPos;
    private float spawnPosX = 35;
    private int startDelay = 2;
    private float spawnInterval = 1.5f;

    // Start is called before the first frame update
    void Start()
    {
        SpawnRandomAnimal();
        InvokeRepeating("SpawnRandomAnimal", startDelay, spawnInterval);
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    void SpawnRandomAnimal()
    {
        int animalIndex = Random.Range(0, animalPrefabs.Length);
        spawnPos = Random.Range(0, 2);
        if (spawnPos == 0)
        {
            Vector3 spawnpos = new Vector3(spawnPosX, 0, Random.Range(-5, spawnRangeZ));
            Instantiate(animalPrefabs[animalIndex], spawnpos, animalPrefabs[animalIndex].transform.rotation);
        }
        else if (spawnPos == 1)
        {
            Vector3 spawnpos = new Vector3(-spawnPosX, 0, Random.Range(-5, spawnRangeZ));
            Instantiate(animalPrefabs[animalIndex], spawnpos, animalPrefabs[animalIndex].transform.rotation);
        }
    }
}
