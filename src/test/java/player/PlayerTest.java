package player;

import enemies.WaveManager;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import tiles.Tile;
import tiles.TileMap;
import tiles.TileType;
import tools.Shovel;
import tools.Trap;
import tools.Trash;
import towers.Tower;

public class PlayerTest {

    private static Player player;
    private static TileMap tileMap;
    private static WaveManager waveManager;

    private static Tile[][] mapica = {
        {new Tile(TileType.Water), new Tile(TileType.LongGrass), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt), new Tile(TileType.Dirt)},
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

    @BeforeClass
    public static void setUp() {
        tileMap = new TileMap(mapica);
        waveManager = new WaveManager();
        player = new Player(tileMap, waveManager);
    }

    @Test
    public void testPickTower() {
        Tower tower = new Tower();
        player.pickTower(tower);
        assertEquals(true, player.isHoldingTower());
    }

    @Test
    public void testPickTrap() {
        Trap trap = new Trap();
        player.pickTrap(trap);
        assertEquals(true, player.isHoldingTrap());
    }

    @Test
    public void testPickShovel() {
        Shovel shovel = new Shovel();
        player.pickShovel(shovel);
        assertEquals(true, player.isHoldingShovel());
    }

    @Test
    public void testPickTrash() {
        Trash trash = new Trash();
        player.pickTrash(trash);
        assertEquals(true, player.isHoldingTrash());
    }

    @Test
    public void testGetTempTrash() {
        Trash trash = new Trash();
        Player.setTempTrash(trash);
        assertSame(trash, Player.getTempTrash());
    }

    @Test
    public void testRefundic() {
        player.setHoldingTrash(true);
        Tower tower = new Tower();
        Player.getListaTurreta().add(tower);
        Trash trash = new Trash();
        Player.setTempTrash(trash);
        player.refundic(mapica[0][0]);
        assertEquals(false, player.isHoldingTrash());
        Player.getListaTurreta().clear();
    }

    @Test
    public void testGetStatus() {
        Trap trap = new Trap();
        trap.setX(64);
        trap.setY(0);
        mapica[0][1].setX(64);
        Player.getListaTrapki().add(trap);
        assertEquals(false, player.getStatus(mapica[0][1]));
        mapica[0][1].setX(0);
        assertEquals(true, player.getStatus(mapica[0][1]));
    }

    @Test
    public void testDestroyTrap() {
        Player.getListaTrapki().clear();
        Trap trap = new Trap();
        Player.getListaTrapki().add(trap);
        Player.destroyTrap();
        assertEquals(1, Player.getListaTrapki().size());
        Player.getListaTrapki().clear();
    }

    @Test
    public void testSetUp() {
        player.setUp();
        assertEquals(100, Player.gold);
        assertEquals(5, Player.lives);
        Player.gold = 0;
        Player.lives = 0;
    }

    @Test
    public void testSpendMoney() {
        Player.gold = 30;
        assertEquals(true, Player.spendMoney(30));
        Player.earnMoney(10);
        assertEquals(false, Player.spendMoney(20));
        Player.gold = 0;
    }

    @Test
    public void testEarnMoney() {
        Player.earnMoney(30);
        assertEquals(30, Player.gold);
    }

    @Test
    public void testReduceLives() {
        Player.lives = 5;
        Player.reduceLives();
        assertEquals(4, Player.lives);
    }

    @Test
    public void testGetListaTrapki() {
        assertEquals(new CopyOnWriteArrayList<>().size(), Player.getListaTrapki().size());
    }

    @Test
    public void testGetListaTurreta() {
        assertEquals(new CopyOnWriteArrayList<>().size(), Player.getListaTurreta().size());
    }

    @Test
    public void testGetWaveNumber() {
        assertEquals(0, Player.getWaveNumber());
    }

    @Test
    public void testPlay() {
        Player.setStatus(true);
        player.play();
        assertEquals(false, Player.getStatus());
    }

    @Test
    public void testPause() {
        player.pause();
        assertEquals(true, Player.getStatus());
    }
}
