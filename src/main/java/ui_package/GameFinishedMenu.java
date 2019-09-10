package ui_package;

import static helpingPackage.StartingUtility.HEIGHT;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import static helpingPackage.StartingUtility.loadTexture;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import states.GameStateType;
import states.StateManager;

public class GameFinishedMenu {

    private final Texture finishedGame;
    private final UIComponents uiComponents;

    public GameFinishedMenu() {
        this.finishedGame = loadTexture("finishedGame");
        uiComponents = new UIComponents();
        uiComponents.addDugme("playAgain", "playButton", 200, (int) (HEIGHT * 0.70));
        uiComponents.addDugme("backDugme", "backButton", 600, (int) (HEIGHT * 0.70));
        uiComponents.addDugme("exitDugme", "exitButton", 1000, (int) (HEIGHT * 0.70));
    }

    private void setAction() {
        if (Mouse.isButtonDown(0)) {
            if (uiComponents.isClicked("playAgain")) {
                StateManager.setGameStateType(GameStateType.GAME);
            } else if (uiComponents.isClicked("exitDugme")) {
                StateManager.setGameStateType(GameStateType.EXIT);
            } else if (uiComponents.isClicked("backDugme")) {
                StateManager.setGameStateType(GameStateType.MAINMENU);
            }
        }
    }

    public void update() {
        drawingTextureSquares(finishedGame, 0, 0, 2048, 1024);
        uiComponents.draw();
        setAction();
    }
}
