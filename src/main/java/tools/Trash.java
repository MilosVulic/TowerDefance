package tools;

import static helpingPackage.StartingUtility.drawingTextureSquares;
import org.newdawn.slick.opengl.Texture;
import player.Player;
import tiles.Tile;
import towers.Tower;

public class Trash {

    private Texture texture;
    private float x, y;
    private int width, height;

    public Trash(Texture texture, Tile startTile) {
        this.texture = texture;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = startTile.getWidth();
        this.height = startTile.getHeigth();
    }

    public Trash() {
    }

    // metoda za brisnaje towera i vracanja odredjenje kinte
    public void destroyTower(Tower tower) {
        Player.getListaTurreta().remove(tower);
        Player.gold += (Math.ceil(tower.getPrice() / 3.0) * 2);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw() {
        drawingTextureSquares(texture, x, y, width, height);
    }
}
