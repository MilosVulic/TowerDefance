package tools;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.newdawn.slick.opengl.Texture;
import tiles.Tile;

public class TrashTest {

    private static Trash trash;
    private static Trash trash1;
    private static Texture texture;
    private static Tile tile;

    @BeforeClass
    public static void setUp() {
        trash = new Trash();
    }

    @Test
    public void construct() {
        tile = new Tile();
        trash1 = new Trash(texture, tile); 
    }

    @Test
    public void testGetX() {
        trash.setX(64);
        assertEquals(64, trash.getX(), 0.0);
    }

    @Test
    public void testGetY() {
        trash.setY(64);
        assertEquals(64, trash.getY(), 0.0);
    }

    @Test
    public void testGetTexture() {
        Texture texture = null;
        trash.setTexture(texture);
        assertEquals(null, trash.getTexture());
    }

    @Test
    public void testGetWidth() {
        trash.setWidth(64);
        assertEquals(64, trash.getWidth(), 0.0);
    }

    @Test
    public void testGetHeight() {
        trash.setHeight(64);
        assertEquals(64, trash.getHeight(), 0.0);
    }
}
