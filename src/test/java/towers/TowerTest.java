package towers;

import enemies.Enemy;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.opengl.Texture;
import projectiles.Projectil;
import tiles.Tile;

public class TowerTest {

    private static Tower tower;
    private Tower tower1;

    @BeforeClass
    public static void setUpClass() {
        tower = new Tower();
    }

    @Test(expected = NullPointerException.class)
    public void construct() {
        TowerType type = null;
        Tile tile = new Tile();
        CopyOnWriteArrayList<Enemy> listaEnemija = new CopyOnWriteArrayList<>();
        tower1 = new Tower(type,tile,listaEnemija);
    }

    @Test
    public void testUpdateEnemyList() {
        CopyOnWriteArrayList<Enemy> listaEnemija = new CopyOnWriteArrayList<>();
        tower.updateEnemyList(listaEnemija);
    }

    @Test
    public void testGetX() {
        tower.setX(2);
        assertEquals(2, tower.getX(), 0.0);
    }

    @Test
    public void testGetY() {
        tower.setY(2);
        assertEquals(2, tower.getY(), 0.0);
    }

    @Test
    public void testGetWidth() {
        tower.setWidth(20);
        assertEquals(20, tower.getWidth(), 0.0);
    }

    @Test
    public void testGetHeight() {
        tower.setHeight(20);
        assertEquals(20, tower.getHeight(), 0.0);
    }

    @Test
    public void testGetTargetovanEnemy() {
        Enemy enemy = new Enemy();
        tower.setTargetovanEnemy(enemy);
        assertSame(enemy, tower.getTargetovanEnemy());
    }

    @Test
    public void testGetTextureTower() {
        Texture expResult = null;
        tower.setTextureTower(expResult);
        assertEquals(null, tower.getTextureTower());
    }

    @Test
    public void testGetTextureGun() {
        Texture expResult = null;
        tower.setTextureGun(expResult);
        assertEquals(null, tower.getTextureGun());
    }

    @Test
    public void testGetListaProjektila() {
        CopyOnWriteArrayList<Projectil> expResult = new CopyOnWriteArrayList<>();
        tower.setListaProjektila(expResult);
        assertEquals(expResult, tower.getListaProjektila());
    }

    @Test
    public void testGetType() {
        tower.setType(null);
        assertEquals(null, tower.getType());
    }

    @Test
    public void testGetPrice() {
        tower.setPrice(30);
        assertEquals(30, tower.getPrice());
    }

    @Test
    public void testSetX1() {
        float x = (float) 20.0;
        Tower.setX1(x);
        assertEquals(20, x, 0.0);
    }

    @Test
    public void testSetY1() {
        float y = (float) 20.0;
        Tower.setY1(y);
        assertEquals(20, y, 0.0);
    }

    @Test
    public void testUpdate() {
        Enemy enemy = new Enemy();
        enemy.setX(15);
        enemy.setY(10);
        tower.getListaEnemija().add(enemy);
        tower.setRadius(30);
        tower.update();
        assertEquals(false, tower.isNaciljan());
        enemy.setX(50);
        tower.update();
        tower.getListaEnemija().clear();
    }

    @Test
    public void testTowerShoot() {
        Enemy en = new Enemy();
        tower.towerShoot(en);
        assertEquals(0, tower.getVremeOdZadnjegPucnja(), 0.0);
    }
}
