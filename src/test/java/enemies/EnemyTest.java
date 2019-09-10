package enemies;

import java.util.ArrayList;
import java.util.List;
import movements.CheckPoint;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.newdawn.slick.opengl.Texture;
import player.Player;
import tiles.Tile;
import tiles.TileMap;

public class EnemyTest {

    private static Enemy enemy;

    @BeforeClass
    public static void setUpClass() {
        enemy = new Enemy();
    }

    @Test
    public void testUpdate() {
        Player.lives = 5;
        enemy.setX(64);
        enemy.setY(64);
        List<CheckPoint> lista = new ArrayList<>();
        Tile tile = new Tile();
        tile.setX(64);
        tile.setY(64);
        int x = 0;
        int y = 1;
        CheckPoint cp = new CheckPoint(tile, x, y);
        enemy.setListaCheckPointeva(lista);
        enemy.getListaCheckPointeva().add(cp);
        enemy.update();
        assertEquals(4, Player.lives);
    }

    @Test
    @Ignore
    public void testDestroyEnemy() {
        Enemy instance = new Enemy();
        instance.destroyEnemy();
    }

    @Test
    @Ignore
    public void testGetWidth() {
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testSetWidth() {
        int width = 0;
        Enemy instance = new Enemy();
        instance.setWidth(width);
    }

    @Test
    @Ignore
    public void testGetHeight() {
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testSetHeight() {
        int height = 0;
        Enemy instance = new Enemy();
        instance.setHeight(height);
    }

    @Test
    @Ignore
    public void testGetHealth() {
        Enemy instance = new Enemy();
        float expResult = 0.0F;
        float result = instance.getHealth();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    @Ignore
    public void testSetHealth() {
        float health = 0.0F;
        Enemy instance = new Enemy();
        instance.setHealth(health);
    }

    @Test
    @Ignore
    public void testGetMovementSpeed() {
        Enemy instance = new Enemy();
        float expResult = 0.0F;
        float result = instance.getMovementSpeed();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    @Ignore
    public void testSetMovementSpeed() {
        float movementSpeed = 0.0F;
        Enemy instance = new Enemy();
        instance.setMovementSpeed(movementSpeed);
    }

    @Test
    @Ignore
    public void testGetTexture() {
        Enemy instance = new Enemy();
        Texture expResult = null;
        Texture result = instance.getTexture();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testSetTexture() {
        Texture texture = null;
        Enemy instance = new Enemy();
        instance.setTexture(texture);
    }

    @Test
    @Ignore
    public void testGetStartingTile() {
        Enemy instance = new Enemy();
        Tile expResult = null;
        Tile result = instance.getStartingTile();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testSetStartingTile() {
        Tile startingTile = null;
        Enemy instance = new Enemy();
        instance.setStartingTile(startingTile);
    }

    @Test
    @Ignore
    public void testGetTileMap() {
        Enemy instance = new Enemy();
        TileMap expResult = null;
        TileMap result = instance.getTileMap();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testIsEnemyAlive() {
        Enemy instance = new Enemy();
        boolean expResult = false;
        boolean result = instance.isEnemyAlive();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testSetEnemyAlive() {
        boolean enemyAlive = false;
        Enemy instance = new Enemy();
        instance.setEnemyAlive(enemyAlive);
    }

    @Test
    @Ignore
    public void testIsFirst() {
        Enemy instance = new Enemy();
        boolean expResult = false;
        boolean result = instance.isFirst();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testSetFirst() {
        boolean first = false;
        Enemy instance = new Enemy();
        instance.setFirst(first);
    }

    @Test
    @Ignore
    public void testGetX() {
        Enemy instance = new Enemy();
        float expResult = 0.0F;
        float result = instance.getX();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    @Ignore
    public void testSetX() {
        float x = 0.0F;
        Enemy instance = new Enemy();
        instance.setX(x);
    }

    @Test
    @Ignore
    public void testGetY() {
        Enemy instance = new Enemy();
        float expResult = 0.0F;
        float result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    @Ignore
    public void testSetY() {
        float y = 0.0F;
        Enemy instance = new Enemy();
        instance.setY(y);
    }

    @Test
    @Ignore
    public void testGetEnemyType() {
        Enemy instance = new Enemy();
        EnemyType expResult = null;
        EnemyType result = instance.getEnemyType();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testSetEnemyType() {
        EnemyType enemyType = null;
        Enemy instance = new Enemy();
        instance.setEnemyType(enemyType);
    }

    @Test
    @Ignore
    public void testGetEnemyWorth() {
        Enemy instance = new Enemy();
        int expResult = 0;
        int result = instance.getEnemyWorth();
        assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testNextYPosition() {
        Enemy instance = new Enemy();
        double expResult = 0.0;
        double result = instance.nextYPosition();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    @Ignore
    public void testNextXPosition() {
        Enemy instance = new Enemy();
        double expResult = 0.0;
        double result = instance.nextXPosition();
        assertEquals(expResult, result, 0.0);
    }
}
