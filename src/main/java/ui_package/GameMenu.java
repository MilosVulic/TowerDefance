package ui_package;

import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.HEIGHT;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import static helpingPackage.StartingUtility.loadTexture;
import java.awt.Font;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import player.Player;

public class GameMenu {

    private final ArrayList<Button> menuListaDugmica;
    private final ArrayList<Button> menuListaToolova;
    private final ArrayList<Button> menuListaGameStatusDugmica;
    private int x, y;
    private int yCounter = 1;
    private int xCounter = 0;
    private int yCounter1 = 1;
    private int xCounter1 = 0;
    private int yCounter2 = 1;
    private int xCounter2 = 0;
    private final Texture gameMenuTexture;
    private TrueTypeFont gameFont;
    private Font fontic;

    public GameMenu(int x, int y) {
        this.gameMenuTexture = loadTexture("gameMenu");
        this.x = x;
        this.y = y;
        this.menuListaDugmica = new ArrayList<>();
        this.menuListaToolova = new ArrayList<>();
        this.menuListaGameStatusDugmica = new ArrayList<>();
        fontic = new Font("Times New Roman", Font.BOLD, 24);
        gameFont = new TrueTypeFont(fontic, false);
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

    public void prerasporedToolova(Button b) {

        if (menuListaToolova.size() % 2 == 0 && menuListaToolova.size() > 0) {
            b.setY(360 + yCounter1 * StartingUtility.SQUARE_SIZE);
            yCounter1++;
            xCounter1 = 0;
        }
        b.setY(360 + (yCounter1 * 16) + yCounter1 * StartingUtility.SQUARE_SIZE);
        b.setX(x + 16 + (xCounter1 * 32) + xCounter1 * StartingUtility.SQUARE_SIZE);
        xCounter1++;
        menuListaDugmica.add(b);
        menuListaToolova.add(b);
    }

    public void prerasporedGameStatusDugmica(Button b) {

        if (menuListaGameStatusDugmica.size() % 2 == 0 && menuListaGameStatusDugmica.size() > 0) {
            b.setY(800 + yCounter2 * 32);
            yCounter2++;
            xCounter2 = 0;
        }
        b.setY(800 + (yCounter2 * 16) + yCounter2 * 32);
        b.setX(x + 16 + (xCounter2 * 32) + xCounter2 * StartingUtility.SQUARE_SIZE);
        xCounter2++;
        menuListaDugmica.add(b);
        menuListaGameStatusDugmica.add(b);
    }

    public void drawChangableText(int x, int y, String changableText) {
        gameFont.drawString(x, y, changableText, Color.black);
        Color.white.bind();
    }

    public void update() {
        drawingTextureSquares(gameMenuTexture, 1280, 0, 192, 960);
        drawChangableText(1330, 680, "Lives  " + Player.lives);
        drawChangableText(1330, 730, "Gold  " + Player.gold);
        drawChangableText(1330, 780, "Wave  " + Player.getWaveNumber());
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
