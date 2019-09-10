package enemies;

import static helpingPackage.StartingUtility.SQUARE_SIZE;
import static helpingPackage.StartingUtility.loadTexture;
import org.newdawn.slick.opengl.Texture;

public enum EnemyType {

    ENEMY_VAMPIRE(loadTexture("vampire"), SQUARE_SIZE, SQUARE_SIZE, 5, 70, 30),
    ENEMY_ONE_EYED_ZOMBIE(loadTexture("oneEyedZombie"), SQUARE_SIZE, SQUARE_SIZE, 10, 70, 50),
    ENEMY_ORANGE_BOSS(loadTexture("orangeBoss"), SQUARE_SIZE, SQUARE_SIZE, 30, 50, 250),
    ENEMY_BLACK_BOSS(loadTexture("boss2"), SQUARE_SIZE, SQUARE_SIZE, 50, 60, 300);

    Texture texture;
    float movementSpeed, health;
    int width, height;
    int worth;

    private EnemyType(Texture texture, int width, int height, int worth, float movementSpeed, float health) {
        this.texture = texture;
        this.movementSpeed = movementSpeed;
        this.health = health;
        this.width = width;
        this.height = height;
        this.worth = worth;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }
}
