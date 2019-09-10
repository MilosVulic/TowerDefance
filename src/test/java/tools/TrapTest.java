package tools;

import enemies.Enemy;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.opengl.Texture;
import player.Player;
import tiles.Tile;

public class TrapTest {

    private static Trap trap;
    private Trap trap1;
    private Tile tile;
    private Texture texture;

    @BeforeClass
    public static void setUpClass() {
        trap = new Trap();
    }

    @Test
    public void constructor() {
        tile = new Tile();
        trap1 = new Trap(texture, tile, trap.getListaEnemija());
    }

    @Test
    public void testGetTrapTexture() {
        Texture trapTexture = null;
        trap.setTrapTexture(trapTexture);
        assertEquals(null, trap.getTrapTexture());
    }

    @Test
    public void testGetX() {
        trap.setX(1);
        assertEquals(1, trap.getX(), 0.0);
    }

    @Test
    public void testGetY() {
        trap.setY(1);
        assertEquals(1, trap.getY(), 0.0);
    }

    @Test
    public void testGetWidth() {
        trap.setWidth(64);
        assertEquals(64, trap.getWidth(), 0.0);
    }

    @Test
    public void testGetHeight() {
        trap.setHeight(64);
        assertEquals(64, trap.getHeight(), 0.0);
    }

    @Test
    public void testGetPrice() {
        trap.setPrice(20);
        assertEquals(20, trap.getPrice());
    }

    @Test
    public void testGetTargetovanEnemy() {
        Enemy enemy = new Enemy();
        trap.setTargetovanEnemy(enemy);
        assertSame(enemy, trap.getTargetovanEnemy());
    }

    @Test
    public void testGetListaEnemija() {
        CopyOnWriteArrayList<Enemy> lista = new CopyOnWriteArrayList<>();
        trap.updateListaEnemija(lista);
        assertEquals(new CopyOnWriteArrayList<>().size(), trap.getListaEnemija().size());
    }

    @Test
    public void testProvideTrapka() {
        trap.setX(1);
        trap.setY(1);
        CopyOnWriteArrayList<Trap> lista = new CopyOnWriteArrayList<>();
        Player.setListaTrapki(lista);
        Player.getListaTrapki().add(trap);
        trap.provideTrapka(1, 1);
        assertSame(trap, Trap.getTemp());
    }

    @Test
    public void testUpdate() {
        Enemy enemy = new Enemy();
        enemy.setEnemyAlive(true);
        trap.getListaEnemija().add(enemy);
        trap.update();
    }
}
