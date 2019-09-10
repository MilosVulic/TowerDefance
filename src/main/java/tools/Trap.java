package tools;

import enemies.Enemy;
import enemies.EnemyType;
import helpingPackage.Entity;
import static helpingPackage.StartingUtility.checkCollision;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import java.util.concurrent.CopyOnWriteArrayList;
import org.newdawn.slick.opengl.Texture;
import player.Player;
import tiles.Tile;

public class Trap implements Entity {

    private Texture trapTexture;
    private float x, y;
    private int width, height, price;
    private Enemy targetovanEnemy;
    private CopyOnWriteArrayList<Enemy> listaEnemija;
    private boolean trapkaExsists;
    private boolean naciljan;
    private static Trap temp;

    public Trap(Texture trapTexture, Tile startTile, CopyOnWriteArrayList<Enemy> listaEnemija) {
        this.trapTexture = trapTexture;
        this.listaEnemija = listaEnemija;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = startTile.getWidth();
        this.height = startTile.getHeigth();
        this.price = 20;
        this.trapkaExsists = true;
        this.naciljan = false;
    }

    public Trap() {
    }

    public Texture getTrapTexture() {
        return trapTexture;
    }

    public void setTrapTexture(Texture trapTexture) {
        this.trapTexture = trapTexture;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Enemy getTargetovanEnemy() {
        return targetovanEnemy;
    }

    public void setTargetovanEnemy(Enemy targetovanEnemy) {
        this.targetovanEnemy = targetovanEnemy;
    }

    public CopyOnWriteArrayList<Enemy> getListaEnemija() {
        return listaEnemija;
    }

    public void updateListaEnemija(CopyOnWriteArrayList<Enemy> listaEnemija) {
        this.listaEnemija = listaEnemija;
    }

    private double findDistance(Enemy enemy) {
        double xDistanca = Math.abs(enemy.getX() - x);
        double yDistanca = Math.abs(enemy.getY() - y);
        return xDistanca + yDistanca;
    }

    private Enemy target() {
        Enemy najbliziEn = null;
        double randomVelikaDistanca = 99999999;
        for (Enemy e : listaEnemija) {
            if (findDistance(e) < randomVelikaDistanca && e.isEnemyAlive()) {
                randomVelikaDistanca = findDistance(e);
                najbliziEn = e;
            }
        }
        if (najbliziEn != null) {
            naciljan = true;
        }
        return najbliziEn;
    }

    @Override
    public void update() {

        if (!naciljan) {
            targetovanEnemy = target();
        }

        if (targetovanEnemy == null || targetovanEnemy.isEnemyAlive() == false) {
            naciljan = false;
        }

        if (trapkaExsists && naciljan) {
            for (int i = 0; i < listaEnemija.size(); i++) {
                if (checkCollision(x, y, width, height, listaEnemija.get(i).getX(), listaEnemija.get(i).getY(), listaEnemija.get(i).getWidth(), listaEnemija.get(i).getHeight())) {
                    if (listaEnemija.get(i).getEnemyType().equals(EnemyType.ENEMY_ORANGE_BOSS) || listaEnemija.get(i).getEnemyType().equals(EnemyType.ENEMY_BLACK_BOSS)) {
                        trapkaExsists = false;
                        provideTrapka(x, y);
                        Player.destroyTrap();
                    } else {
                        trapkaExsists = false;
                        listaEnemija.get(i).destroyEnemy();
                        Player.earnMoney(listaEnemija.get(i).getEnemyWorth());
                        provideTrapka(x, y);
                        Player.destroyTrap();
                    }
                }
            }
            draw();
        }
    }

    public void provideTrapka(float x, float y) {
        for (Trap trap : Player.getListaTrapki()) {
            if (trap.getX() == x && trap.getY() == y) {
                temp = trap;
            }
        }
    }

    @Override
    public void draw() {
        drawingTextureSquares(trapTexture, x, y, width, height);
    }

    public static Trap getTemp() {
        return temp;
    }

}
