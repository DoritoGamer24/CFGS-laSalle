using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnManager : MonoBehaviour
{
    public GameObject[] enemyPrefab;
    public GameObject[] powerupPrefab;
    private float spawnRange = 9;
    public int waveNumber = 3;
    // Start is called before the first frame update
    void Start()
    {
        SpawnEnemyWave(waveNumber);
    }

    void SpawnEnemyWave(int enemyToSpawn)
    {
        for (int i = 0; i < enemyToSpawn; i++)
        {
            int randEnemy = Random.Range(0, 3);
            Instantiate(enemyPrefab[randEnemy], GenerateSpawnPosition(), enemyPrefab[randEnemy].transform.rotation);
        }
        int randPower = Random.Range(0, 2);
        Instantiate(powerupPrefab[randPower], GenerateSpawnPosition(), powerupPrefab[randPower].transform.rotation);
    }
    private Vector3 GenerateSpawnPosition()
    {
        float spawnPosX = Random.Range(-spawnRange, spawnRange);
        float spawnPosZ = Random.Range(-spawnRange, spawnRange);
        Vector3 randomPos = new Vector3(spawnPosX, 0, spawnPosX);
        return randomPos;
    }

    public int enemyCount;
    

    // Update is called once per frame
    void Update()
    {
        enemyCount = FindObjectsOfType<Enemy>().Length;
        if (enemyCount == 0)
        {
            waveNumber++;
            SpawnEnemyWave(waveNumber);
        }
    }
}
