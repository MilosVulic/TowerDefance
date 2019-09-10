package player;

import enemies.Wave;
import enemies.WaveManager;
import helpingPackage.Clock;
import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.HEIGHT;
import java.util.concurrent.CopyOnWriteArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import states.GameStateType;
import states.StateManager;
import tiles.Tile;
import tiles.TileMap;
import tiles.TileType;
import tools.Shovel;
import towers.Tower;
import tools.Trap;
import tools.Trash;

public class Player {

    public static int gold, lives;
    private static TileMap tileMap;
    private static WaveManager waveManger;
    private static CopyOnWriteArrayList<Tower> listaTurreta;
    private static CopyOnWriteArrayList<Trap> listaTrapki;
    private boolean leviClickPreviously;
    private Tower tempTower;
    private static Trap tempTrap;
    private static Shovel tempShovel;
    private static Trash tempTrash;
    private boolean holdingTower, holdingTrap, holdingShovel, holdingTrash;
    private static boolean status;

    public Player(TileMap tileMap, WaveManager waveManger) {
        Player.tileMap = tileMap;
        Player.waveManger = waveManger;
        Player.listaTurreta = new CopyOnWriteArrayList<>();
        Player.listaTrapki = new CopyOnWriteArrayList<>();
        this.leviClickPreviously = false;
        this.holdingTower = false;
        this.holdingTrap = false;
        this.holdingShovel = false;
        this.holdingTrash = false;
    }

    /*
    Metoda za iscrtavanje elementa kad se samo mrda mis.
    Takodje za placovanje elemenata
    I sadrzi keyboard trigere za debug mode
    */
    public void update() {

        if (holdingTower) {
            tempTower.setX(getTileFromTheMouse().getX());
            tempTower.setY(getTileFromTheMouse().getY());
            tempTower.draw();
        } else if (holdingTrap) {
            tempTrap.setX(getTileFromTheMouse().getX());
            tempTrap.setY(getTileFromTheMouse().getY());
            tempTrap.draw();
        } else if (holdingShovel) {
            tempShovel.setX(getTileFromTheMouse().getX());
            tempShovel.setY(getTileFromTheMouse().getY());
            tempShovel.draw();
        } else if (holdingTrash) {
            tempTrash.setX(getTileFromTheMouse().getX());
            tempTrash.setY(getTileFromTheMouse().getY());
            tempTrash.draw();
        }

        for (Tower tower : listaTurreta) {
            tower.update();
            tower.updateEnemyList(Wave.getLista());
            tower.draw();
        }

        for (Trap trap : listaTrapki) {
            trap.update();
            trap.updateListaEnemija(Wave.getLista());
            trap.draw();
        }

        // stavljanje svega i svacega na grid
        if (Mouse.isButtonDown(0) && leviClickPreviously == false) {
            placeTheTower();
            placeTheTrap();
            digTravicu(getTileFromTheMouse());
            refundic(getTileFromTheMouse());
        }
        leviClickPreviously = Mouse.isButtonDown(0);

        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(0.2);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(-0.2);
            }
        }
    }

    public void pickTower(Tower tower) {
        tempTower = tower;
        holdingTower = true;
        holdingTrap = false;
        holdingShovel = false;
        holdingTrash = false;
    }

    public void pickTrap(Trap trap) {
        tempTrap = trap;
        holdingTrap = true;
        holdingShovel = false;
        holdingTower = false;
        holdingTrash = false;
    }

    public void pickShovel(Shovel shovel) {
        tempShovel = shovel;
        holdingShovel = true;
        holdingTower = false;
        holdingTrap = false;
        holdingTrash = false;
    }

    public void pickTrash(Trash trash) {
        tempTrash = trash;
        holdingTrash = true;
        holdingShovel = false;
        holdingTower = false;
        holdingTrap = false;
    }

    private void placeTheTower() {
        Tile tempTile = getTileFromTheMouse();
        if (holdingTower) {
            if (tempTile.isBuildable() && spendMoney(tempTower.getPrice())) {
                listaTurreta.add(tempTower);
                holdingTower = false;
                tempTile.setBuildable(false);
            }
        }
    }

    private void placeTheTrap() {
        Tile tempTile = getTileFromTheMouse();
        if (holdingTrap) {
            if (getStatus(tempTile) == true && tempTile.getType().equals(TileType.Dirt) && spendMoney(tempTrap.getPrice())) {
                listaTrapki.add(tempTrap);
                holdingTrap = false;
            }
        }
    }

    private void digTravicu(Tile tile) {
        if (holdingShovel) {
            if (tile.getType().equals(TileType.LongGrass) && spendMoney(tempShovel.getPrice())) {
                holdingShovel = false;
                tempShovel.dig(tile);
            }
        }
    }

    public void refundic(Tile tile) {
        if (holdingTrash) {
            for (Tower tower : listaTurreta) {
                if (tile.getX() == tower.getX() && tile.getY() == tower.getY()) {
                    tempTrash.destroyTower(tower);
                    holdingTrash = false;
                    tile.setBuildable(true);
                }
            }
        }
    }

    public boolean getStatus(Tile tempTile) {
        for (Trap t : listaTrapki) {
            if (t.getX() == tempTile.getX() && t.getY() == tempTile.getY()) {
                return false;
            }
        }
        return true;
    }

    public static void destroyTrap() {
        listaTrapki.remove(Trap.getTemp());
    }

    private Tile getTileFromTheMouse() {
        return tileMap.getTile((HEIGHT - Mouse.getY() - 1) / StartingUtility.SQUARE_SIZE, Mouse.getX() / StartingUtility.SQUARE_SIZE);
    }

    public void setUp() {
        gold = 100;
        lives = 5;
    }

    public static boolean spendMoney(int price) {
        if (gold - price < 0) {
            return false;
        } else {
            gold -= price;
            return true;
        }
    }

    public static void earnMoney(int amount) {
        gold += amount;
    }

    public static void reduceLives() {
        lives--;
    }

    public static CopyOnWriteArrayList<Trap> getListaTrapki() {
        return listaTrapki;
    }

    public static void setListaTrapki(CopyOnWriteArrayList<Trap> listaTrapki) {
        Player.listaTrapki = listaTrapki;
    }

    public static CopyOnWriteArrayList<Tower> getListaTurreta() {
        return listaTurreta;
    }

    public static int getWaveNumber() {
        return waveManger.getBrojWave();
    }

    public static void checkGameStatus() {
        if (lives <= 0) {
            resetToBuildableFields();
            StateManager.setGameStateType(GameStateType.GAME_OVER);
        } else if (getWaveNumber() == 15) {
            resetToBuildableFields();
            StateManager.setGameStateType(GameStateType.FINISHED);
        } else if (getWaveNumber() == 14 && Wave.isEndWave()) {
            resetToBuildableFields();
            StateManager.setGameStateType(GameStateType.FINISHED);
        }
    }

    // resetovanje tilova na buildable da opet moze da se gradi nesto
    public static void resetToBuildableFields() {
        for (Tower tower : listaTurreta) {
            tileMap.getTile((int) (tower.getY() / 64), (int) (tower.getX() / 64)).setBuildable(true);
        }
    }

    public void play() {
        if (status == true) {
            Clock.pause();
            Clock.paused = false;
            status = false;
        }
    }

    public void pause() {
        if (status == false) {
            Clock.pause();
            Clock.paused = true;
            status = true;
        }
    }

    public static boolean getStatus() {
        return status;
    }

    public static void setStatus(boolean status) {
        Player.status = status;
    }

    public boolean isHoldingShovel() {
        return holdingShovel;
    }

    public boolean isHoldingTower() {
        return holdingTower;
    }

    public boolean isHoldingTrap() {
        return holdingTrap;
    }

    public boolean isHoldingTrash() {
        return holdingTrash;
    }

    public void setHoldingTrash(boolean holdingTrash) {
        this.holdingTrash = holdingTrash;
    }

    public static Trash getTempTrash() {
        return tempTrash;
    }

    public static void setTempTrash(Trash tempTrash) {
        Player.tempTrash = tempTrash;
    }
}
