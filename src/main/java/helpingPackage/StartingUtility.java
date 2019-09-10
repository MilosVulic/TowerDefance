package helpingPackage;

import java.io.IOException;
import java.io.InputStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class StartingUtility {

    public static final int WIDTH = 1472;
    public static final int HEIGHT = 960;
    public static final int SQUARE_SIZE = 64;

    // kreiranje ekrana tj pocetnog panela
    public static void beginSession() {
        Display.setTitle("Neko ime");
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException ex) {
            ex.printStackTrace();
        }

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    // metoda za koliziju koja vraca true ili false u zavisnosti od toga da je doslo do inteceptovanja ili ne
    public static boolean checkCollision(float x1, float y1, float width1, float height1, float x2, float y2, float width2, float height2) {
        if (x1 + width1 > x2 && x1 < x2 + width2 && y1 + height1 > y2 && y1 < y2 + height2) {
            return true;
        }
        return false;
    }

    // iscrtavanje textura odnosno quadova u odnosu na prosledjene parametre
    public static void drawingTextureSquares(Texture texture, float x, float y, float width, float height) {
        texture.bind();
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);

        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        glTexCoord2f(1, 0);
        glVertex2f(width, 0);
        glTexCoord2f(1, 1);
        glVertex2f(width, height);
        glTexCoord2f(0, 1);
        glVertex2f(0, height);

        glEnd();
        glLoadIdentity();
    }

    // iscrtavanje objekta sa parametrom za ugao odosno za rotaciju
    public static void drawingTextureRotating(Texture texture, float x, float y, float width, float height, float angle) {
        texture.bind();
        glTranslatef(x + width / 2, y + height / 2, 0);
        glRotatef(angle, 0, 0, 1);
        glTranslatef(-width / 2, -height / 2, 0);
        glBegin(GL_QUADS);

        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        glTexCoord2f(1, 0);
        glVertex2f(width, 0);
        glTexCoord2f(1, 1);
        glVertex2f(width, height);
        glTexCoord2f(0, 1);
        glVertex2f(0, height);

        glEnd();
        glLoadIdentity();
    }

    // metoda za vracanje texture
    public static Texture loadTexture(String putanja, String extenzija) {
        Texture tex = null;
        InputStream input = ResourceLoader.getResourceAsStream(putanja);
        try {
            tex = TextureLoader.getTexture(extenzija, input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tex;
    }

    // metoda koja sadrzi poziv metode za vracanje texture
    public static Texture loadTexture(String putanja) {
        Texture tex;
        tex = loadTexture("" + putanja + ".png", "PNG");
        return tex;
    }
}
