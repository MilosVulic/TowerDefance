package towers;

import static helpingPackage.StartingUtility.loadTexture;
import org.newdawn.slick.opengl.Texture;
import projectiles.ProjectileType;

public enum TowerType {

    TOWER_BASIC_SHOOTER(loadTexture("towerBasic"), loadTexture("towerBasicGun"), ProjectileType.BULLET_GRAY, 500, 3,20),
    TOWER_FREEZER(loadTexture("towerFreezer"), loadTexture("towerFreezerGun"), ProjectileType.FROZEN_BULLET, 500, 3,40);

    Texture textureTower;
    Texture textureGun;
    ProjectileType projectileTip;
    float damage;
    double attackSpeed;
    double radius;
    int price;

    private TowerType(Texture textureTower, Texture textureGun, ProjectileType projectileTip, double radius, double attackSpeed, int price) {
        this.textureTower = textureTower;
        this.textureGun = textureGun;
        this.projectileTip = projectileTip;
        this.radius = radius;
        this.attackSpeed = attackSpeed;
        this.price = price;
        this.damage = projectileTip.getDamage();
    }  
}
