package tiles;

import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.loadTexture;
import org.newdawn.slick.opengl.Texture;

public class Tile {

    private float x, y;
    private int width, heigth;
    private Texture texture;
    private TileType type;
    private boolean buildable;

    public Tile() {
    }

    public Tile(float x, float y, int width, int heigth, TileType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.type = type;
        this.texture = loadTexture(type.tip);
        setBuildable();
    }

    public Tile(TileType tileType) {
        this.type = tileType;
    }

    public float getX() {
        return x;
    }

    public int getXGridPozicija() {
        return (int) x / StartingUtility.SQUARE_SIZE;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public int getYGridPozicija() {
        return (int) y / StartingUtility.SQUARE_SIZE;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public void setBuildable() {
        if (type.buildable) {
            buildable = true;
        } else {
            buildable = false;
        }
    }

    public boolean isBuildable() {
        return buildable;
    }

    public void setBuildable(boolean buildable) {
        this.buildable = buildable;
    }
}
