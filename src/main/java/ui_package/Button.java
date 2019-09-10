package ui_package;

import org.newdawn.slick.opengl.Texture;

public class Button {

    private String ime;
    private Texture buttonTexture;
    private int x, y;
    private int width, height;

    public Button(String ime, Texture buttonTexture, int x, int y, int width, int height) {
        this.ime = ime;
        this.buttonTexture = buttonTexture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Button(String ime, Texture buttonTexture, int x, int y) {
        this.ime = ime;
        this.buttonTexture = buttonTexture;
        this.x = x;
        this.y = y;
        this.width = buttonTexture.getImageWidth();
        this.height = buttonTexture.getImageHeight();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Texture getButtonTexture() {
        return buttonTexture;
    }

    public void setButtonTexture(Texture buttonTexture) {
        this.buttonTexture = buttonTexture;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
   
}
