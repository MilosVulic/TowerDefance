package movements;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiles.Tile;
import tiles.TileType;

public class CheckPointTest {

    private static CheckPoint check;
    private static Tile tile;
    private static int x;
    private static int y;


    @BeforeClass
    public static void setUp() {
        CheckPointTest.x = 5;
        CheckPointTest.y = 6;
        CheckPointTest.tile = new Tile(TileType.Dirt);
        check = new CheckPoint(tile, x, y);
    }


    @Test
    public void testGetTile() {
        assertEquals(TileType.Dirt, check.getTile().getType());
    }


    @Test
    public void testGetXosa() {
        assertEquals(5, check.getXosa());
    }


    @Test
    public void testGetYosa() {
        assertEquals(6, check.getYosa());
    }
}
