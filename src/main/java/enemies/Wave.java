package enemies;

import static helpingPackage.Clock.delta;
import java.util.concurrent.CopyOnWriteArrayList;

public class Wave {

    private float timeSinceLastSpawn;
    private double spawnTime;
    private int brojEnemijaPerWave;
    private int brojSpamovanihEnemija;
    private static boolean endWave;
    private Enemy[] nizceEnemija;
    private static CopyOnWriteArrayList<Enemy> lista;

    public Wave() {
    }

    public Wave(Enemy[] nizceEnemija, double spawnTime) {
        this.spawnTime = spawnTime;
        this.nizceEnemija = nizceEnemija;
        this.brojEnemijaPerWave = nizceEnemija.length;
        this.timeSinceLastSpawn = 0;
        Wave.lista = new CopyOnWriteArrayList<>();
        Wave.endWave = false;
        spawn();
    }

    public void update() {
        boolean areEnemiesDead = true;
        if (brojSpamovanihEnemija < brojEnemijaPerWave) {
            timeSinceLastSpawn += delta();
            if (timeSinceLastSpawn > spawnTime) {
                spawn();
                timeSinceLastSpawn = 0;
            }
        }
        for (Enemy e : lista) {
            if (e.isEnemyAlive()) {
                areEnemiesDead = false;
                e.update();
                e.draw();
            } else {
                lista.remove(e);
            }
        }
        if (areEnemiesDead && brojSpamovanihEnemija == brojEnemijaPerWave) {
            endWave = true;
        }
    }

    public void spawn() {
        lista.add(nizceEnemija[brojSpamovanihEnemija]);
        brojSpamovanihEnemija++;
    }

    public static boolean isEndWave() {
        return endWave;
    }

    public static CopyOnWriteArrayList<Enemy> getLista() {
        return (CopyOnWriteArrayList<Enemy>) lista;
    }

}
