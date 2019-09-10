package ui_package;

import static helpingPackage.StartingUtility.HEIGHT;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import static helpingPackage.StartingUtility.loadTexture;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Mouse;

public class UIComponents {

    private final List<Button> listaDugmica;

    public UIComponents() {
        this.listaDugmica = new ArrayList<>();
    }

    public void addDugme(String ime, String textureName, int x, int y) {
        listaDugmica.add(new Button(ime, loadTexture(textureName), x, y));
    }

    public boolean isClicked(String imeDugeta) {
        Button button = getButton(imeDugeta);
        double mouseY = HEIGHT - Mouse.getY() - 1;
        return Mouse.getX() > button.getX() && Mouse.getX() < button.getX() + button.getWidth() && mouseY > button.getY() && mouseY < button.getY() + button.getHeight();
    }

    private Button getButton(String imeDugeta) {
        for (Button b : listaDugmica) {
            if (b.getIme().equals(imeDugeta)) {
                return b;
            }
        }
        return null;
    }

    public void draw() {
        for (Button button : listaDugmica) {
            drawingTextureSquares(button.getButtonTexture(), button.getX(), button.getY(), button.getWidth(), button.getHeight());
        }
    }
}
