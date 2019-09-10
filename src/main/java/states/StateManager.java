package states;

import data.GameEngine;
import static helpingPackage.TileMapManager.loadMap;
import tiles.TileMap;
import ui_package.GameFinishedMenu;
import ui_package.GameOverMenu;
import ui_package.InfoMenu;

public class StateManager {

    public static MainMenu mainMenu;
    public static Editor editor;
    public static GameStateType gameState = GameStateType.MAINMENU;
    public static GameEngine gameEngine;
    public static InfoMenu infoMenu;
    private GameOverMenu gameOver;
    private GameFinishedMenu gameFinished;
    public static TileMap tileMap = loadMap("drislja");

    /*
    Provera i promena kad koj state, dal je kraj gejma dal treba da se ode na mainMneu na info panel itd
    */

    public void update() {
        switch (gameState) {
            case MAINMENU:
                if (mainMenu == null) {
                    mainMenu = new MainMenu();
                }
                gameEngine = null;
                mainMenu.update();
                break;
            case EDITOR:
                if (editor == null) {
                    editor = new Editor();
                }
                editor.update();
                break;
            case GAME:
                if (gameEngine == null) {
                    gameEngine = new GameEngine(tileMap);
                }
                gameEngine.update();
                break;
            case INFO:
                if (infoMenu == null) {
                    infoMenu = InfoMenu.getInstance();
                }
                infoMenu.update();
                break;
            case GAME_OVER:
                if (gameOver == null) {
                    gameOver = new GameOverMenu();
                }
                gameEngine = null;
                gameOver.update();
                break;
            case FINISHED:
                if (gameFinished == null) {
                    gameFinished = new GameFinishedMenu();
                }
                gameEngine = null;
                gameFinished.update();
                break;
            case EXIT:
                System.exit(0);
                break;
        }
    }

    public static void setGameStateType(GameStateType newState) {
        gameState = newState;
    }
}
