package states;

import data.GameEngine;
import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.HEIGHT;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import static helpingPackage.StartingUtility.loadTexture;
import static helpingPackage.TileMapManager.loadMap;
import static helpingPackage.TileMapManager.saveMap;
import org.lwjgl.input.Mouse;
import tiles.Tile;
import tiles.TileMap;
import tiles.TileType;
import ui_package.Button;
import ui_package.EditorMenu;

public class Editor {

    private final TileMap tileMap;
    private TileType[] types;
    private int index;
    private EditorMenu editorMenu;
    private boolean holdingTile;
    private Tile tempTile;

    public Editor() {
        setUp();
        tileMap = loadMap("drislja");
        populatingArray();
    }

    public void update() {
        tileMap.drawTiles();
        editorMenu.update();
        setOnClick();
    }

    private void setOnClick() {

        if (holdingTile) {
            tempTile.setX(getTileFromTheMouse().getX());
            tempTile.setY(getTileFromTheMouse().getY());
            drawingTextureSquares(tempTile.getTexture(), tempTile.getX(), tempTile.getY(), tempTile.getWidth(), tempTile.getHeigth());
        }
        setOnActionFromMenu();
    }

    private void setTile() {
        tileMap.setTile((int) Math.floor(Mouse.getX() / StartingUtility.SQUARE_SIZE), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / StartingUtility.SQUARE_SIZE), types[index]);
    }

    private Tile getTileFromTheMouse() {
        return tileMap.getTile((HEIGHT - Mouse.getY() - 1) / StartingUtility.SQUARE_SIZE, Mouse.getX() / StartingUtility.SQUARE_SIZE);
    }

    private void populatingArray() {
        this.types = new TileType[4];
        types[0] = TileType.Grass;
        types[1] = TileType.Dirt;
        types[2] = TileType.Water;
        types[3] = TileType.LongGrass;
    }

    private void setUp() {
        editorMenu = new EditorMenu(1280, 64);
        editorMenu.prerasporedDugmica(new Button("grass", loadTexture("grass"), 0, 0));
        editorMenu.prerasporedDugmica(new Button("water", loadTexture("water"), 0, 0));
        editorMenu.prerasporedDugmica(new Button("longGrass", loadTexture("longGrass"), 0, 0));
        editorMenu.prerasporedDugmica(new Button("dirt", loadTexture("dirt"), 0, 0));
        editorMenu.prerasporedGameStatusDugmica(new Button("save", loadTexture("saveButton"), 0, 0));
        editorMenu.prerasporedGameStatusDugmica(new Button("back", loadTexture("smallBackButton"), 0, 0));
    }

    private void setOnActionFromMenu() {
        if (Mouse.isButtonDown(0)) {
            if (editorMenu.isClicked("grass")) {
                holdingTile = true;
                index = 0;
                tempTile = new Tile(0, 0, 64, 64, TileType.Grass);
            } else if (editorMenu.isClicked("water")) {
                holdingTile = true;
                index = 2;
                tempTile = new Tile(0, 0, 64, 64, TileType.Water);
            } else if (editorMenu.isClicked("longGrass")) {
                holdingTile = true;
                index = 3;
                tempTile = new Tile(0, 0, 64, 64, TileType.LongGrass);
            } else if (editorMenu.isClicked("dirt")) {
                holdingTile = true;
                index = 1;
                tempTile = new Tile(0, 0, 64, 64, TileType.Dirt);
            } else if (editorMenu.isClicked("save")) {
                saveMap("drislja", tileMap);
                StateManager.tileMap = loadMap("drislja");
            } else if (editorMenu.isClicked("back")) {
                StateManager.setGameStateType(GameStateType.MAINMENU);
            } else {
                holdingTile = false;
                setTile();
            }
        }
    }

    public TileMap getTileMap() {
        return tileMap;
    }

}
