package data;

import enemies.Wave;
import enemies.WaveManager;
import factory.DefanceFactory;
import static helpingPackage.StartingUtility.loadTexture;
import org.lwjgl.input.Mouse;
import player.Player;
import states.GameStateType;
import states.StateManager;
import tiles.TileMap;
import tools.Shovel;
import tools.Trap;
import tools.Trash;
import ui_package.Button;
import ui_package.GameMenu;

public class GameEngine {

    private TileMap tileMap;
    private Player player;
    private WaveManager waveManager;
    private GameMenu gameMenu;

    public GameEngine(TileMap mapa) {
        this.tileMap = mapa;
        waveManager = new WaveManager(2, tileMap, tileMap.getTile(0, 2));
        player = new Player(tileMap, waveManager);
        player.setUp();
        setUp();
    }

    // setovanje dugmica na right-sajd baru
    private void setUp() {
        gameMenu = new GameMenu(1280, 64);
        gameMenu.prerasporedDugmica(new Button("basicShooterFull", loadTexture("towerBasicShooterFull"), 0, 0));
        gameMenu.prerasporedDugmica(new Button("freezerFull", loadTexture("towerFreezerFull"), 0, 0));
        gameMenu.prerasporedDugmica(new Button("trash", loadTexture("refund"), 0, 0));
        gameMenu.prerasporedToolova(new Button("trap", loadTexture("hole"), 0, 0));
        gameMenu.prerasporedToolova(new Button("kopanje", loadTexture("shovel"), 0, 0));
        gameMenu.prerasporedGameStatusDugmica(new Button("play", loadTexture("smallPlayButton"), 0, 0));
        gameMenu.prerasporedGameStatusDugmica(new Button("pause", loadTexture("pauseButton"), 0, 0));
        gameMenu.prerasporedGameStatusDugmica(new Button("back", loadTexture("smallBackButton"), 0, 0));
    }

    // handlovanje dugmica
    private void updateUI() {
        gameMenu.update();
        if (Mouse.isButtonDown(0)) {
            if (gameMenu.isClicked("basicShooterFull")) {
                player.pickTower(DefanceFactory.getDefanceType("TowerBasic", tileMap.getTile(0, 0)));
            } else if (gameMenu.isClicked("freezerFull")) {
                player.pickTower(DefanceFactory.getDefanceType("TowerFreezer", tileMap.getTile(0, 0)));
            } else if (gameMenu.isClicked("trap")) {
                player.pickTrap(new Trap(loadTexture("hole"), tileMap.getTile(0, 0), Wave.getLista()));
            } else if (gameMenu.isClicked("kopanje")) {
                player.pickShovel(new Shovel(loadTexture("shovel"), tileMap.getTile(0, 0), tileMap));
            } else if (gameMenu.isClicked("trash")) {
                player.pickTrash(new Trash(loadTexture("refund"), tileMap.getTile(0, 0)));
            } else if (gameMenu.isClicked("play")) {
                player.play();
            } else if (gameMenu.isClicked("pause")) {
                player.pause();
            } else if (gameMenu.isClicked("back")) {
                player.play();
                Player.resetToBuildableFields();
                StateManager.setGameStateType(GameStateType.MAINMENU);
            }
        }
    }

    public void update() {
        tileMap.drawTiles();
        waveManager.update();
        player.update();
        updateUI();
        Player.checkGameStatus();
    }
}
