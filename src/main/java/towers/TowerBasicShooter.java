package towers;

import enemies.Enemy;
import helpingPackage.StartingUtility;
import java.util.concurrent.CopyOnWriteArrayList;
import projectiles.ProjectilGray;
import tiles.Tile;

public class TowerBasicShooter extends Tower {

    public TowerBasicShooter(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> listaEnemija) {
        super(type, startTile, listaEnemija);
    }

    public TowerBasicShooter() {
    }

    @Override
    public void towerShoot(Enemy enemy) {
        super.towerShoot(enemy);
        super.getListaProjektila().add(new ProjectilGray(super.getType().projectileTip, super.getX() + StartingUtility.SQUARE_SIZE / 4, super.getY() + StartingUtility.SQUARE_SIZE / 4, 32, 32, enemy));
    }
}
