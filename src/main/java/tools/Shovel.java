package tools;

import static helpingPackage.StartingUtility.drawingTextureSquares;
import org.newdawn.slick.opengl.Texture;
import tiles.Tile;
import tiles.TileMap;
import tiles.TileType;

public class Shovel {

    private Texture texture;
    private float x, y;
    private int width, height, price;
    private TileMap tileMap;

    public Shovel() {
    }

    
    public Shovel(Texture texture, Tile startTile, TileMap tileMap) {
        this.texture = texture;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = startTile.getWidth();
        this.height = startTile.getHeigth();
        this.price = 15;
        this.tileMap = tileMap;
    }


    // promena long travice u obicnu travicu 
    public void dig(Tile tile) {
        if (tile.getType().equals(TileType.LongGrass)) {
            tileMap.setTile(tile.getXGridPozicija(), tile.getYGridPozicija(), TileType.Grass);
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
