package projectiles;

import enemies.Enemy;
import enemies.Wave;
import static helpingPackage.Clock.delta;
import helpingPackage.Entity;
import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.checkCollision;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import org.newdawn.slick.opengl.Texture;
import player.Player;
import towers.Tower;

public class Projectil implements Entity {

    private Texture texture;
    private float x, y, damage;
    private double speed;
    private int width, height;
    private double xVelocity, yVelocity;
    private static Enemy targetovanEnemy;
    private boolean projectileActive;
    private static double celoVreme;

    public Projectil(ProjectileType type, float x, float y, int width, int height, Enemy targetovanEnemy) {
        this.texture = type.textureBullet;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = type.speed;
        this.damage = type.damage;
        this.projectileActive = true;
        Projectil.targetovanEnemy = targetovanEnemy;
        izracunajSmer();
    }

    @Override
    public void draw() {
        drawingTextureSquares(texture, x, y, width, height);
    }

    // Metodica koja racuna gde da ide kuglica i kolko da prelazi u nekom vremenskom intervali
    // prvo izracunam kolko vremena treba da kuglica doputuje do enmija kad ga prvi put targetuje
    // kad to uradim onda u enemy klasi dobijem poziciju gde da puknem unapred da bi metak interceptovao enemija 
    // i onda puknem u tom pravcu
    private void izracunajSmer() {

        double xUdaljenostFromEnemy = Math.abs(targetovanEnemy.getX() - x + StartingUtility.SQUARE_SIZE / 4);
        double yUdaljenostFromEnemy = Math.abs(targetovanEnemy.getY() - y + StartingUtility.SQUARE_SIZE / 4);   
        double distance1 = Math.sqrt(Math.pow(xUdaljenostFromEnemy, 2) + Math.pow(yUdaljenostFromEnemy, 2));
        Projectil.celoVreme = distance1 / speed;
        
        //System.out.println("Targetovan x " + targetovanEnemy.getX() + " Novi x " + targetovanEnemy.nextXPosition());
        //System.out.println("Targetovan y " + targetovanEnemy.getY() + " Novi y " + targetovanEnemy.nextYPosition());
        double xUda = Math.abs(targetovanEnemy.nextXPosition() - x + StartingUtility.SQUARE_SIZE / 4);
        double yUda = Math.abs(targetovanEnemy.nextYPosition() - y + StartingUtility.SQUARE_SIZE / 4);
        double dist = Math.sqrt(Math.pow(xUda, 2) + Math.pow(yUda, 2));

        xVelocity = xUda / dist;
        yVelocity = yUda / dist;

        if (targetovanEnemy.nextXPosition() < x) {
            xVelocity *= -1;
        }
        if (targetovanEnemy.nextYPosition() < y) {
            yVelocity *= -1;
        }
    }

    public static double getCeloVreme() {
        return celoVreme;
    }

    @Override
    public void update() {
        if (targetovanEnemy.isEnemyAlive() == false && projectileActive) {
            projectileActive = false;
        }
        if (projectileActive) {
            //izracunajSmer();
            //System.out.println(" xVelocity " + xVelocity + " yVelocity " + yVelocity);

            x += delta() * speed * xVelocity;
            y += delta() * speed * yVelocity;
            //System.out.println(" xVelocity = " +  xVelocity + " yVelocity = " + yVelocity);
            for (int i = 0; i < Wave.getLista().size(); i++) {
                if (checkCollision(x, y, width, height, Wave.getLista().get(i).getX(), Wave.getLista().get(i).getY(), Wave.getLista().get(i).getWidth(), Wave.getLista().get(i).getHeight())) {
                    //Tower.deleteProjectile(x, y);
                    Tower.setX1(x);
                    Tower.setY1(y);
                    projectileActive = false;
                    hurtEnemy(Wave.getLista().get(i));
                    break;
                }
            }
            for (int i = 0; i < Wave.getLista().size(); i++) {
                double xPrethodnaUdaljenost = Math.abs(Wave.getLista().get(i).getX() - x);
                double yPrethodnaUdaljenost = Math.abs(Wave.getLista().get(i).getY() - y);
                double ukupnoPrethodna = xPrethodnaUdaljenost + yPrethodnaUdaljenost;
                double sledeciX = x + (delta() * speed * xVelocity);
                double sledeciY = y + (delta() * speed * yVelocity);
                double xSledecaUdaljenost = Math.abs(Wave.getLista().get(i).getX() - sledeciX);
                double ySledecaUdaljenost = Math.abs(Wave.getLista().get(i).getY() - sledeciY);
                double ukupnoSledeca = xSledecaUdaljenost + ySledecaUdaljenost;
                if (ukupnoSledeca > ukupnoPrethodna + 20) {
                    projectileActive = false;
                } else {
                    draw();
                }
            }
        }
    }

    public void hurtEnemy(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - damage);
        if (enemy.getHealth() <= 0) {
            enemy.destroyEnemy();
            Player.earnMoney(enemy.getEnemyWorth());
        }
    }

    public static Enemy getTargetovanEnemy() {
        return targetovanEnemy;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    } 
}
