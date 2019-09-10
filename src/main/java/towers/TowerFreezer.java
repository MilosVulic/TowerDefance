package towers;

import enemies.Enemy;
import helpingPackage.StartingUtility;
import java.util.concurrent.CopyOnWriteArrayList;
import projectiles.ProjectileFrozen;
import tiles.Tile;

public class TowerFreezer extends Tower {

    public TowerFreezer(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> listaEnemija) {
        super(type, startTile, listaEnemija);
    }

    public TowerFreezer() {
        
    }

    @Override
    public void towerShoot(Enemy enemy) {
        super.towerShoot(enemy);
        super.getListaProjektila().add(new ProjectileFrozen(super.getType().projectileTip, super.getX() + StartingUtility.SQUARE_SIZE / 4, super.getY() + StartingUtility.SQUARE_SIZE / 4, 32, 32, enemy));
    }
}
