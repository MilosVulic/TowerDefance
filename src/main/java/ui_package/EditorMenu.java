package ui_package;

import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.HEIGHT;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import static helpingPackage.StartingUtility.loadTexture;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

public class EditorMenu {

    private final ArrayList<Button> menuListaDugmica;
    private final ArrayList<Button> menuListaGameStatusDugmica;
    private int x, y;
    private int yCounter = 1;
    private int xCounter = 0;
    private int yCounter1 = 1;
    private int xCounter1 = 0;
    private final Texture editorMenuTexture;

    public EditorMenu(int x, int y) {
        this.editorMenuTexture = loadTexture("editorMenu");
        this.x = x;
        this.y = y;
        this.menuListaDugmica = new ArrayList<>();
        this.menuListaGameStatusDugmica = new ArrayList<>();
    }

    public void prerasporedDugmica(Button b) {

        if (menuListaDugmica.size() % 2 == 0 && menuListaDugmica.size() > 0) {
            b.setY(y + yCounter * StartingUtility.SQUARE_SIZE);
            yCounter++;
            xCounter = 0;
        }
        b.setY(y + (yCounter * 16) + yCounter * StartingUtility.SQUARE_SIZE);
        b.setX(x + 16 + (xCounter * 32) + xCounter * StartingUtility.SQUARE_SIZE);
        xCounter++;
        menuListaDugmica.add(b);
    }

    public void prerasporedGameStatusDugmica(Button b) {

        if (menuListaGameStatusDugmica.size() % 2 == 0 && menuListaGameStatusDugmica.size() > 0) {
            b.setY(800 + yCounter1 * 32);
            yCounter1++;
            xCounter1 = 0;
        }
        b.setY(800 + (yCounter1 * 16) + yCounter1 * 32);
        b.setX(x + 16 + (xCounter1 * 32) + xCounter1 * StartingUtility.SQUARE_SIZE);
        xCounter1++;
        menuListaDugmica.add(b);
        menuListaGameStatusDugmica.add(b);
    }

    public void update() {
        drawingTextureSquares(editorMenuTexture, 1280, 0, 192, 960);
        for (Button button : menuListaDugmica) {
            drawingTextureSquares(button.getButtonTexture(), button.getX(), button.getY(), button.getWidth(), button.getHeight());
        }
    }

    public boolean isClicked(String imeDugeta) {
        Button button = getButton(imeDugeta);
        double mouseY = HEIGHT - Mouse.getY() - 1;
        return Mouse.getX() > button.getX() && Mouse.getX() < button.getX() + button.getWidth() && mouseY > button.getY() && mouseY < button.getY() + button.getHeight();
    }

    private Button getButton(String imeDugeta) {
        for (Button b : menuListaDugmica) {
            if (b.getIme().equals(imeDugeta)) {
                return b;
            }
        }
        return null;
    }
}
