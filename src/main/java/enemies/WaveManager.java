package enemies;

import static helpingPackage.Clock.delta;
import tiles.Tile;
import tiles.TileMap;

public class WaveManager {

    private double vremeOdLastWave, spawnTime;
    private int brojWave;
    private int brojEnemijaPerWave;
    private int evenEnemyCountUpdater, oddEnemyCountUpdater, everyThirdCountUpdater, everyFifthCountUpdater, everyTenthCounterUpdater, every13Counter;
    private Wave wave;
    private Enemy[] nizEnemija;
    private TileMap tileMap;
    private Tile tile;

    public WaveManager(double spawnTime, TileMap map, Tile startingTile) {
        this.tileMap = map;
        this.tile = startingTile;
        this.spawnTime = spawnTime;
        this.brojEnemijaPerWave = 2;
        createWave();
    }

    public WaveManager() {
    }

    public void update() {
        if (!wave.isEndWave()) {
            wave.update();
        } else if (wave.isEndWave()) {
            vremeOdLastWave += delta();
            if (vremeOdLastWave >= spawnTime) {
                createWave();
                vremeOdLastWave = 0;
            }
        }
    }

    /* Definisanje metoda za kreiranje wave:
   paran, neparan, svaki 3, svaki 5, svaki 10, svaki 13,
     */
    private void setUpEvenWaves() {
        nizEnemija = new Enemy[brojEnemijaPerWave + evenEnemyCountUpdater];
        for (int i = 0; i < nizEnemija.length; i++) {
            nizEnemija[i] = new Enemy(EnemyType.ENEMY_ONE_EYED_ZOMBIE, tile, tileMap);
        }
    }

    private void setUpOddWaves() {
        nizEnemija = new Enemy[brojEnemijaPerWave + oddEnemyCountUpdater];
        for (int i = 0; i < nizEnemija.length; i++) {
            nizEnemija[i] = new Enemy(EnemyType.ENEMY_VAMPIRE, tile, tileMap);
        }
    }

    private void setUpEveryThirdWaves() {
        nizEnemija = new Enemy[brojEnemijaPerWave + everyThirdCountUpdater];
        for (int i = 0; i < nizEnemija.length; i++) {
            if (i % 2 == 0) {
                nizEnemija[i] = new Enemy(EnemyType.ENEMY_ONE_EYED_ZOMBIE, tile, tileMap);
            } else {
                nizEnemija[i] = new Enemy(EnemyType.ENEMY_VAMPIRE, tile, tileMap);
            }
        }
    }

    private void setUpFifthWaves() {
        nizEnemija = new Enemy[everyFifthCountUpdater + 1];
        for (int i = 0; i < nizEnemija.length; i++) {
            nizEnemija[i] = new Enemy(EnemyType.ENEMY_ORANGE_BOSS, tile, tileMap);
        }
    }

    private void setUpTenthWaves() {
        nizEnemija = new Enemy[everyTenthCounterUpdater + 1];
        for (int i = 0; i < nizEnemija.length; i++) {
            nizEnemija[i] = new Enemy(EnemyType.ENEMY_BLACK_BOSS, tile, tileMap);
        }
    }

    private void setUpEvery13Wave() {
        nizEnemija = new Enemy[every13Counter + 2];
        for (int i = 0; i < nizEnemija.length; i++) {
            if (i % 2 == 0) {
                nizEnemija[i] = new Enemy(EnemyType.ENEMY_BLACK_BOSS, tile, tileMap);
            } else {
                nizEnemija[i] = new Enemy(EnemyType.ENEMY_ORANGE_BOSS, tile, tileMap);
            }
        }
    }

    // poziv ovih metoda u zavisnoti od toga da li je neparan paran itd
    private void setUpWave() {
        if (brojWave > 0 && brojWave % 13 == 0) {
            setUpEvery13Wave();
            every13Counter++;
        } else if (brojWave > 0 && brojWave % 10 == 0) {
            setUpTenthWaves();
            everyTenthCounterUpdater++;
        } else if (brojWave > 0 && brojWave % 5 == 0) {
            setUpFifthWaves();
            everyFifthCountUpdater++;
        } else if (brojWave > 0 && brojWave % 3 == 0) {
            setUpEveryThirdWaves();
            everyThirdCountUpdater++;
        } else if (brojWave % 2 == 0) {
            setUpEvenWaves();
            evenEnemyCountUpdater++;
        } else if (brojWave % 2 == 1) {
            setUpOddWaves();
            oddEnemyCountUpdater++;
        }
    }

    // kreiraje wav-a
    private void createWave() {
        brojWave++;
        setUpWave();
        wave = new Wave(nizEnemija, spawnTime);
    }

    public Wave getWave() {
        return wave;
    }

    public int getBrojWave() {
        return brojWave;
    }
}
