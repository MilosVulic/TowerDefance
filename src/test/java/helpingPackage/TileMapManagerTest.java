package helpingPackage;

import org.junit.Test;
import static org.junit.Assert.*;
import tiles.Tile;
import tiles.TileMap;
import tiles.TileType;

public class TileMapManagerTest {

    Tile[][] mapica = {
        {new Tile(TileType.Water), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
        {new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},};


    @Test
    public void testGetString() {
        TileMap tileMap = new TileMap(mapica);
        assertEquals('2', TileMapManager.getString(tileMap).charAt(0));
    }

    /**
     * Test of getTileType method, of class TileMapManager.
     */
    @Test
    public void testGetTileType() {
        assertEquals(TileType.Grass, TileMapManager.getTileType("0"));
        assertEquals(TileType.Dirt, TileMapManager.getTileType("1"));
        assertEquals(TileType.Water, TileMapManager.getTileType("2"));
        assertEquals(TileType.LongGrass, TileMapManager.getTileType("3"));
        assertEquals(null, TileMapManager.getTileType("4"));
    }

    /**
     * Test of getTileId method, of class TileMapManager.
     */
    @Test
    public void testGetTileId1() {
        Tile tile;
        tile = new Tile(TileType.Dirt);
        assertEquals("1", TileMapManager.getTileId(tile));
        tile = new Tile(TileType.Grass);
        assertEquals("0", TileMapManager.getTileId(tile));
        tile = new Tile(TileType.Water);
        assertEquals("2", TileMapManager.getTileId(tile));
        tile = new Tile(TileType.LongGrass);
        assertEquals("3", TileMapManager.getTileId(tile));
        tile = new Tile(TileType.Test);
        assertEquals(null, TileMapManager.getTileId(tile));
    }
}
