using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class spawnManager : MonoBehaviour
{
    public GameObject[] enemyPrefab;
    private float spawnRangeSide = 7;
    private float spawnRangeTop = 10;
    private float spawnRangeBottom = 5;
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
    }
    private Vector3 GenerateSpawnPosition()
    {
        float spawnPosX = Random.Range(-spawnRangeSide, spawnRangeSide);
        float spawnPosZ = Random.Range(spawnRangeBottom, spawnRangeTop);
        Vector3 randomPos = new Vector3(spawnPosX, 0.55f, spawnPosZ);
        return randomPos;
    }

    public int enemyCount;


    // Update is called once per frame
    void Update()
    {
        enemyCount = FindObjectsOfType<enemy>().Length;
        if (enemyCount == 0)
        {
            waveNumber = Random.Range(3, 5);
            SpawnEnemyWave(waveNumber);
        }
    }
}
