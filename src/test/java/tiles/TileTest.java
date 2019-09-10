package tiles;

import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.opengl.Texture;

public class TileTest {

    @Test
    public void testGetX() {
        Tile instance = new Tile();
        instance.setX(10);
        assertEquals(10, instance.getX(), 0.0);
    }

    @Test
    public void testGetXGridPozicija() {
        Tile instance = new Tile();
        instance.setX(128);
        assertEquals(2, instance.getXGridPozicija());
    }

    @Test
    public void testSetX() {
        Tile instance = new Tile();
        instance.setX(10);
        assertEquals(10, instance.getX(), 0.0);
    }

    @Test
    public void testGetY() {
        Tile instance = new Tile();
        instance.setY(10);
        assertEquals(10, instance.getY(), 0.0);
    }

    @Test
    public void testGetYGridPozicija() {
        Tile instance = new Tile();
        instance.setY(128);
        assertEquals(2, instance.getYGridPozicija());
    }

    @Test
    public void testSetY() {
        Tile instance = new Tile();
        instance.setY(10);
        assertEquals(10, instance.getY(), 0.0);
    }

    @Test
    public void testGetWidth() {
        Tile instance = new Tile();
        instance.setWidth(64);
        assertEquals(64, instance.getWidth());
    }

    @Test
    public void testSetWidth() {
        Tile instance = new Tile();
        instance.setWidth(64);
        assertEquals(64, instance.getWidth());
    }

    @Test
    public void testGetHeigth() {
        Tile instance = new Tile();
        instance.setHeigth(64);
        assertEquals(64, instance.getHeigth());
    }

    @Test
    public void testSetHeigth() {
        Tile instance = new Tile();
        instance.setHeigth(64);
        assertEquals(64, instance.getHeigth());
    }

    @Test
    public void testGetTexture() {
        Tile instance = new Tile();
        assertEquals(null, instance.getTexture());
    }


    @Test
    public void testSetTexture() {
        Texture texture = null;
        Tile instance = new Tile();
        instance.setTexture(texture);
        assertEquals(null, instance.getTexture());
    }


    @Test
    public void testGetType() {
        Tile instance = new Tile();
        instance.setType(TileType.Test);
        assertEquals(TileType.Test, instance.getType());
    }


    @Test
    public void testSetType() {
        Tile instance = new Tile();
        instance.setType(TileType.Test);
        assertEquals(TileType.Test, instance.getType());
    }


    @Test
    public void testIsBuildable() {
        Tile instance = new Tile();
        instance.setBuildable(true);
        assertEquals(true, instance.isBuildable());
    }

    @Test
    public void testSetBuildable() {
        Tile instance = new Tile(TileType.Grass);
        assertEquals(true, instance.getType().buildable);
    }
    
    @Test
    public void testSetBuildable1() {
        Tile instance = new Tile(TileType.Test);
        instance.setBuildable();
        assertEquals(false, instance.isBuildable());
        instance.setType(TileType.Grass);
        instance.setBuildable();
        assertEquals(true, instance.isBuildable());
    }
}
