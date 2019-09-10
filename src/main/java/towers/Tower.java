package towers;

import enemies.Enemy;
import enemies.Wave;
import static helpingPackage.Clock.delta;
import helpingPackage.Entity;
import static helpingPackage.StartingUtility.drawingTextureRotating;
import static helpingPackage.StartingUtility.drawingTextureSquares;

import java.util.concurrent.CopyOnWriteArrayList;
import org.newdawn.slick.opengl.Texture;
import projectiles.Projectil;
import tiles.Tile;

public class Tower implements Entity, TowerBehaviour {

    private float x, y, ugao;
    private int width, height, price;
    private double radius;
    private double attackSpeed;
    private Enemy targetovanEnemy;
    private Texture textureTower, textureGun;
    private CopyOnWriteArrayList<Enemy> listaEnemija;
    private CopyOnWriteArrayList<Projectil> listaProjektila;
    private boolean naciljan;
    private float vremeOdZadnjegPucnja;
    private TowerType type;
    private static float x1, y1;

    public Tower(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> listaEnemija) {
        this.type = type;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = startTile.getWidth();
        this.height = startTile.getHeigth();
        this.radius = type.radius;
        this.textureTower = type.textureTower;
        this.textureGun = type.textureGun;
        this.attackSpeed = type.attackSpeed;
        this.listaProjektila = new CopyOnWriteArrayList<>();
        this.listaEnemija = listaEnemija;
        this.naciljan = false;
        this.price = type.price;
    }

    public Tower() {
    }

    private Enemy target() {
        Enemy najbliziEn = null;
        double randomVelikaDistanca = 99999999;
        for (Enemy e : listaEnemija) {
            if (isEnemyInRange(e) && findDistance(e) < randomVelikaDistanca) {
                randomVelikaDistanca = findDistance(e);
                najbliziEn = e;
            }
        }
        if (najbliziEn != null) {
            naciljan = true;
        }
        return najbliziEn;
    }

    private boolean isEnemyInRange(Enemy enemy) {
        double xDistanca = Math.abs(enemy.getX() - x);
        double yDistanca = Math.abs(enemy.getY() - y);
        if (xDistanca < radius && yDistanca < radius) {
            return true;
        }
        return false;
    }

    private double findDistance(Enemy enemy) {
        double xDistanca = Math.abs(enemy.getX() - x);
        double yDistanca = Math.abs(enemy.getY() - y);
        return xDistanca + yDistanca;
    }

    private float izracunajUgao() {
        double tempAng = Math.atan2(targetovanEnemy.getY() - y, targetovanEnemy.getX() - x);
        return (float) Math.toDegrees(tempAng) - 90;
    }

    public void updateEnemyList(CopyOnWriteArrayList<Enemy> listaEnemija) {
        this.listaEnemija = listaEnemija;
    }

    public CopyOnWriteArrayList<Enemy> getListaEnemija() {
        return listaEnemija;
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

    public Enemy getTargetovanEnemy() {
        return targetovanEnemy;
    }

    public void setTargetovanEnemy(Enemy targetovanEnemy) {
        this.targetovanEnemy = targetovanEnemy;
    }

    public Texture getTextureTower() {
        return textureTower;
    }

    public void setTextureTower(Texture textureTower) {
        this.textureTower = textureTower;
    }

    public Texture getTextureGun() {
        return textureGun;
    }

    public void setTextureGun(Texture textureGun) {
        this.textureGun = textureGun;
    }

    public CopyOnWriteArrayList<Projectil> getListaProjektila() {
        return listaProjektila;
    }

    public void setListaProjektila(CopyOnWriteArrayList<Projectil> listaProjektila) {
        this.listaProjektila = listaProjektila;
    }

    public TowerType getType() {
        return type;
    }

    public void setType(TowerType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getVremeOdZadnjegPucnja() {
        return vremeOdZadnjegPucnja;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isNaciljan() {
        return naciljan;
    }
     
    
    private void deleteProjectile(float x, float y) {
        for (int i = 0; i < listaProjektila.size(); i++) {
            if (listaProjektila.get(i).getX() == x && listaProjektila.get(i).getY() == y) {
                listaProjektila.remove(i);
            }
        }
    }

    public static void setX1(float x) {
        Tower.x1 = x;
    }

    public static void setY1(float y) {
        Tower.y1 = y;
    }

    @Override
    public void update() {
        if (naciljan && isEnemyInRange(targetovanEnemy)) {
            ugao = izracunajUgao();
            if (vremeOdZadnjegPucnja > attackSpeed) {
                towerShoot(targetovanEnemy);
            }
        } else if (!naciljan) {
            vremeOdZadnjegPucnja = 0;
            targetovanEnemy = target();
        }
        if (Wave.isEndWave()) {
            listaProjektila.clear();
            vremeOdZadnjegPucnja = 0;
        }
        if (targetovanEnemy == null || targetovanEnemy.isEnemyAlive() == false || isEnemyInRange(targetovanEnemy) == false) {
            naciljan = false;
        } else if (naciljan == true) {
            vremeOdZadnjegPucnja += delta();
            for (Projectil p : listaProjektila) {
                deleteProjectile(x1, y1);
                p.update();
            }
            draw();
        }
    }

    @Override
    public void draw() {
        drawingTextureSquares(textureTower, x, y, width, height);
        drawingTextureRotating(textureGun, x, y, width, height, ugao);
    }

    @Override
    public void towerShoot(Enemy en) {
        vremeOdZadnjegPucnja = 0;
    }
}
