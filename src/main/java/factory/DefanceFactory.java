package factory;

import enemies.Wave;
import tiles.Tile;
import towers.Tower;
import towers.TowerBasicShooter;
import towers.TowerFreezer;
import towers.TowerType;

public class DefanceFactory {
    
    /* factory pattern
       U zavisnosti od prolsedjenog parametra vraca odredjeni objekat
    */

    public static Tower getDefanceType(String defType, Tile startTile) {
        if (defType == null) {
            return null;
        } else if (defType.equalsIgnoreCase("TowerBasic")) {
            return new TowerBasicShooter(TowerType.TOWER_BASIC_SHOOTER, startTile, Wave.getLista());
        } else if (defType.equalsIgnoreCase("TowerFreezer")) {
            return new TowerFreezer(TowerType.TOWER_FREEZER, startTile, Wave.getLista());
        }
        return null;
    }
}
