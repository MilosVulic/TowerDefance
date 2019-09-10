package states;

import static helpingPackage.StartingUtility.HEIGHT;
import static helpingPackage.StartingUtility.WIDTH;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import static helpingPackage.StartingUtility.loadTexture;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import ui_package.UIComponents;

public class MainMenu {

    private final Texture backgroundTexture;
    private final Texture sideBar;
    private final UIComponents uiComponents;

    public MainMenu() {
        this.backgroundTexture = loadTexture("background");
        this.sideBar = loadTexture("beggingSideBar");
        uiComponents = new UIComponents();
        uiComponents.addDugme("playDugme", "playButton", WIDTH / 20, (int) (HEIGHT * 0.30));
        uiComponents.addDugme("infoDugme", "infoButton", WIDTH / 20, (int) (HEIGHT * 0.40));
        uiComponents.addDugme("editDugme", "editButton", WIDTH / 20, (int) (HEIGHT * 0.50));
        uiComponents.addDugme("exitDugme", "exitButton", WIDTH / 20, (int) (HEIGHT * 0.60));

    }

    private void setAction() {
        if (Mouse.isButtonDown(0)) {
            if (uiComponents.isClicked("playDugme")) {
                StateManager.setGameStateType(GameStateType.GAME);
            } else if (uiComponents.isClicked("exitDugme")) {
                StateManager.setGameStateType(GameStateType.EXIT);
            } else if (uiComponents.isClicked("editDugme")) {
                StateManager.setGameStateType(GameStateType.EDITOR);
            } else if (uiComponents.isClicked("infoDugme")) {
                StateManager.setGameStateType(GameStateType.INFO);
            }
        }
    }

    public void update() {
        drawingTextureSquares(backgroundTexture, 0, 0, 2048, 1024);
        drawingTextureSquares(sideBar, 1280, 0, 192, 960);
        uiComponents.draw();
        setAction();
    }
}
