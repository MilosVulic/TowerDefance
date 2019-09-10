package projectiles;

import static helpingPackage.StartingUtility.loadTexture;
import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {

    BULLET_GRAY(loadTexture("bullet"), 10, 800),
    FROZEN_BULLET(loadTexture("frozenBullet"), 5, 800);

    Texture textureBullet;
    float damage;
    double speed;

    private ProjectileType(Texture textureBullet, float damage, double speed) {
        this.textureBullet = textureBullet;
        this.damage = damage;
        this.speed = speed;
    }

    public float getDamage() {
        return damage;
    } 
}
