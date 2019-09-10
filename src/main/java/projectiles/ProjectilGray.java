package projectiles;

import enemies.Enemy;

public class ProjectilGray extends Projectil {

    public ProjectilGray(ProjectileType type, float x, float y, int width, int height, Enemy targetovanEnemy) {
        super(type, x, y, width, height, targetovanEnemy);
    }

    @Override
    public void hurtEnemy(Enemy enemy) {
        super.hurtEnemy(enemy);
    }
}
