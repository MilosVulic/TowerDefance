package projectiles;

import enemies.Enemy;

public class ProjectileFrozen extends Projectil {

    public ProjectileFrozen(ProjectileType type, float x, float y, int width, int height, Enemy targetovanEnemy) {
        super(type, x, y, width, height, targetovanEnemy);
    }

    @Override
    public void hurtEnemy(Enemy enemy) {
        super.hurtEnemy(enemy);
        float speed = enemy.getEnemyType().getMovementSpeed() / 2;
        enemy.setMovementSpeed(speed);
    }
}
