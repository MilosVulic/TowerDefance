package tools;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.opengl.Texture;
import tiles.Tile;
import tiles.TileMap;

public class ShovelTest {

    private Shovel shovel;
    private Shovel shovel1;
    private Texture texture;
    private TileMap tileMap;
    private Tile tile;

    public ShovelTest() {
        shovel = new Shovel();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Test
    public void construct() {
        Tile[][] map = new Tile[2][2];
        tileMap = new TileMap(map);
        tile = new Tile();
        shovel1 = new Shovel(texture, tile, tileMap);
    }

    @Test
    public void testGetPrice() {
        shovel.setPrice(12);
        assertEquals(12, shovel.getPrice());
    }

    @Test
    public void testGetX() {
        shovel.setX(10);
        assertEquals(10, shovel.getX(), 0.0);
    }

    @Test
    public void testGetY() {
        shovel.setY(10);
        assertEquals(10, shovel.getY(), 0.0);
    }

    @Test
    public void testGetTexture() {
        Texture texture = null;
        shovel.setTexture(texture);
        assertEquals(null, shovel.getTexture());
    }

    @Test
    public void testGetWidth() {
        shovel.setWidth(64);
        assertEquals(64, shovel.getWidth());
    }

    @Test
    public void testGetHeight() {
        shovel.setHeight(64);
        assertEquals(64, shovel.getHeight());
    }
}
