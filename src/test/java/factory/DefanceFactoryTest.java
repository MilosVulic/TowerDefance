package factory;

import org.junit.Test;
import static org.junit.Assert.*;
import tiles.Tile;
import towers.TowerBasicShooter;


public class DefanceFactoryTest {
    
    @Test
    public void testGetDefanceType() {
        Tile tile = new Tile();
        TowerBasicShooter tower = null;
        assertSame(tower, DefanceFactory.getDefanceType(null, tile));
    }    
}
