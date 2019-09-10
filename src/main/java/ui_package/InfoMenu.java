package ui_package;

import static helpingPackage.StartingUtility.HEIGHT;
import static helpingPackage.StartingUtility.WIDTH;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import static helpingPackage.StartingUtility.loadTexture;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import states.GameStateType;
import states.StateManager;

public class InfoMenu {

    private final Texture backgroundTexture;
    private final UIComponents uiComponents;
    private static InfoMenu infoMenu = new InfoMenu();

    private InfoMenu() {
        this.backgroundTexture = loadTexture("infoMenu");
        uiComponents = new UIComponents();
        uiComponents.addDugme("back", "smallBackButton", WIDTH - 150, (int) (HEIGHT - 200));
    }

    public static InfoMenu getInstance() {
        return infoMenu;
    }

    private void setAction() {
        if (Mouse.isButtonDown(0)) {
            if (uiComponents.isClicked("back")) {
                StateManager.setGameStateType(GameStateType.MAINMENU);
            }
        }
    }

    public void update() {
        drawingTextureSquares(backgroundTexture, 0, 0, 2048, 1024);
        uiComponents.draw();
        setAction();
    }
}
