package enemies;

import static helpingPackage.Clock.delta;
import helpingPackage.Entity;
import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.drawingTextureSquares;
import java.util.ArrayList;
import java.util.List;
import movements.CheckPoint;
import org.newdawn.slick.opengl.Texture;
import player.Player;
import projectiles.Projectil;
import tiles.Tile;
import tiles.TileMap;

public class Enemy implements Entity {

    private int width, height, currentCheckPoint;
    private float x, y, movementSpeed, health, baseHealth;
    private Texture texture, healthBorder, healthBackground, healthForeground;
    private Tile startingTile;
    private boolean first;
    private boolean enemyAlive;
    private TileMap tileMap;
    private int counterX, counterY;
    private boolean counteredXLastly;
    private boolean counteredYLastly;
    private List<CheckPoint> listaCheckPointeva;
    private EnemyType enemyType;

    // x direkcija je index 0 ,  y direkcija je index 1
    private int[] directions;

    public Enemy() {
    }

    public Enemy(EnemyType enemyType, Tile startingTile, TileMap tileMap) {
        this.texture = enemyType.texture;
        this.enemyType = enemyType;
        this.healthBackground = StartingUtility.loadTexture("backgroundHealthBar");
        this.healthForeground = StartingUtility.loadTexture("foregroundHealthBar");
        this.healthBorder = StartingUtility.loadTexture("border");
        this.startingTile = startingTile;
        this.x = startingTile.getX();
        this.y = startingTile.getY();
        this.width = enemyType.width;
        this.height = enemyType.height;
        this.health = enemyType.health;
        this.baseHealth = health;
        this.movementSpeed = enemyType.movementSpeed;
        this.tileMap = tileMap;
        this.first = true;
        this.enemyAlive = true;
        this.listaCheckPointeva = new ArrayList<>();
        this.directions = new int[2];
        this.directions = findDirection(startingTile);
        punjenjeListeCP();
    }

    // draw metoda koju updejtujem i updejtujem health enemija
    @Override
    public void draw() {
        float healthPosto = health / baseHealth;
        drawingTextureSquares(texture, x, y, width, height);
        drawingTextureSquares(healthBackground, x, y - 5, width, 8);
        drawingTextureSquares(healthForeground, x, y - 5, StartingUtility.SQUARE_SIZE * healthPosto, 8);
        drawingTextureSquares(healthBorder, x, y - 5, width, 8);
    }

    // update metoda za refreshovanje pozicija enemija
    @Override
    public void update() {
        if (first) {
            first = false;
        } else {
            if (checkPointReached()) {
                if (currentCheckPoint + 1 == listaCheckPointeva.size()) {
                    enemyHasReachedEnd();
                } else {
                    currentCheckPoint++;
                }
            } else {
                x += delta() * listaCheckPointeva.get(currentCheckPoint).getXosa() * movementSpeed;
                y += delta() * listaCheckPointeva.get(currentCheckPoint).getYosa() * movementSpeed;
            }
        }
    }

    private boolean checkPointReached() {
        boolean reached = false;
        Tile curretnTile = listaCheckPointeva.get(currentCheckPoint).getTile();
        // proveravamo da li je pozicija reachovana sa varijacijom od po 3 piksela
        if (x > curretnTile.getX() - 3 && x < curretnTile.getX() + 3 && y > curretnTile.getY() - 3 && y < curretnTile.getY() + 3) {
            reached = true;
            // resetovanje na stvarnu poziciju jer je prethodno dozvoljena varijacija
            x = curretnTile.getX();
            y = curretnTile.getY();
        }
        return reached;
    }

    private void punjenjeListeCP() {
        listaCheckPointeva.add(findCheckPoint(startingTile, directions = findDirection(startingTile)));
        boolean nastaviti = true;
        int counter = 0;

        while (nastaviti) {
            //  System.out.println("da vidimo x je " + listaCheckPointeva.get(counter).getTile().getXGridPozicija() + "da vidimo y je " + listaCheckPointeva.get(counter).getTile().getYGridPozicija());
            int[] currentDirekcija = findDirection(listaCheckPointeva.get(counter).getTile());
            if (currentDirekcija[0] == 2 || counter == 20) {
                nastaviti = false;
            } else {
                listaCheckPointeva.add(findCheckPoint(listaCheckPointeva.get(counter).getTile(), directions = findDirection(listaCheckPointeva.get(counter).getTile())));
            }
            counter++;
        }
    }

    /* metoda koja vraca checkPoint tako sto loopujemo sve dok ne nadjemo tile koji nije isti kao svi prthodni,
    i ako nadjemo takav, vratim se tile unazad to radi counter--, i nadjem taj tile koji predstavlja checkpoint
     */
    private CheckPoint findCheckPoint(Tile currentEnemyPlace, int[] directions) {
        Tile nextTile = null;
        boolean found = false;
        int counter = 1;

        while (found == false) {
            if (currentEnemyPlace.getType() != tileMap.getTile(currentEnemyPlace.getYGridPozicija() + directions[1] * counter, currentEnemyPlace.getXGridPozicija() + directions[0] * counter).getType()) {
                found = true;
                counter--;
                nextTile = tileMap.getTile(currentEnemyPlace.getYGridPozicija() + directions[1] * counter, currentEnemyPlace.getXGridPozicija() + directions[0] * counter);
            }
            counter++;
        }

        CheckPoint checkPoint = new CheckPoint(nextTile, directions[0], directions[1]);
        return checkPoint;
    }

    /* Metoda koja za neki current enemy tile gde se enemy zapravo nalazi u tom odredjenom trenutku
       Ispitivanje za sve tilove koji surranduju taj current tile 
       da li taj current tile ima istu texturu kao i neki koji ga surranduje 
       I ako ima isti tile, stavljamo njegove direkcije u taj niz na 0 indexu je x osa na 1 je y*/
    private int[] findDirection(Tile currentEnemyPlace) {
        int[] nizDirekcija = new int[2];
        Tile up = tileMap.getTile(currentEnemyPlace.getYGridPozicija() - 1, currentEnemyPlace.getXGridPozicija());
        Tile down = tileMap.getTile(currentEnemyPlace.getYGridPozicija() + 1, currentEnemyPlace.getXGridPozicija());
        Tile right = tileMap.getTile(currentEnemyPlace.getYGridPozicija(), currentEnemyPlace.getXGridPozicija() + 1);
        Tile left = tileMap.getTile(currentEnemyPlace.getYGridPozicija(), currentEnemyPlace.getXGridPozicija() - 1);

        if (currentEnemyPlace.getType() == up.getType() && directions[1] != 1) {
            nizDirekcija[0] = 0;
            nizDirekcija[1] = -1;
        } else if (currentEnemyPlace.getType() == right.getType() && directions[0] != -1) {
            nizDirekcija[0] = 1;
            nizDirekcija[1] = 0;
        } else if (currentEnemyPlace.getType() == down.getType() && directions[1] != -1) {
            nizDirekcija[0] = 0;
            nizDirekcija[1] = 1;
        } else if (currentEnemyPlace.getType() == left.getType() && directions[0] != 1) {
            nizDirekcija[0] = -1;
            nizDirekcija[1] = 0;
        } else {
            nizDirekcija[0] = 2;
            nizDirekcija[1] = 2;
        }
        return nizDirekcija;
    }

    private void enemyHasReachedEnd() {
        destroyEnemy();
        Player.reduceLives();
    }

    public void destroyEnemy() {
        this.enemyAlive = false;
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

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Tile getStartingTile() {
        return startingTile;
    }

    public void setStartingTile(Tile startingTile) {
        this.startingTile = startingTile;
    }

    public TileMap getTileMap() {
        return tileMap;
    }

    public boolean isEnemyAlive() {
        return enemyAlive;
    }

    public void setEnemyAlive(boolean enemyAlive) {
        this.enemyAlive = enemyAlive;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
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

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(EnemyType enemyType) {
        this.enemyType = enemyType;
    }

    public int getEnemyWorth() {
        return enemyType.worth;
    }

    public List<CheckPoint> getListaCheckPointeva() {
        return listaCheckPointeva;
    }

    public void setListaCheckPointeva(List<CheckPoint> listaCheckPointeva) {
        this.listaCheckPointeva = listaCheckPointeva;
    }

    public int getCurrentCheckPoint() {
        return currentCheckPoint;
    }

    public void setCurrentCheckPoint(int currentCheckPoint) {
        this.currentCheckPoint = currentCheckPoint;
    }

    // vracam sledecu y poziciju na koju ce da bude enemija za odredjeno vreme
    public double nextYPosition() {
        if (y + Projectil.getCeloVreme() * listaCheckPointeva.get(currentCheckPoint).getYosa() * movementSpeed >= listaCheckPointeva.get(currentCheckPoint).getTile().getY()) {
            //System.out.println(" counterY je " + counterY + "  current " + currentCheckPoint);
            if (counteredYLastly == false) {
                counterY++;
                counteredYLastly = true;
                counteredXLastly = false;
            }
            return listaCheckPointeva.get(currentCheckPoint).getTile().getY();
        }
        counterY = resetCounter(counterY);
        //System.out.println(" counterY je " + counterY + "  current " + currentCheckPoint);
        return (y + Projectil.getCeloVreme() * listaCheckPointeva.get(counterY).getYosa() * movementSpeed) - (listaCheckPointeva.get(currentCheckPoint).getTile().getX() - Projectil.getTargetovanEnemy().getX());
    }

    // vracam sledecu x poziciju na koju ce da bude enemija za odredjeno vreme
    public double nextXPosition() {
        if (x + Projectil.getCeloVreme() * listaCheckPointeva.get(currentCheckPoint).getXosa() * movementSpeed >= listaCheckPointeva.get(currentCheckPoint).getTile().getX()) {
            System.out.println(" counterX je " + counterX + "  current " + currentCheckPoint);
            if (counteredXLastly == false) {
                counterX++;
                counteredXLastly = true;
                counteredYLastly = false;
            }
            return listaCheckPointeva.get(currentCheckPoint).getTile().getX();
        }
        //System.out.println(" counterX je " + counterX + "  current " + currentCheckPoint);
        counterX = resetCounter(counterX);
        return (x + Projectil.getCeloVreme() * listaCheckPointeva.get(counterX).getXosa() * movementSpeed) - (listaCheckPointeva.get(currentCheckPoint).getTile().getY() - Projectil.getTargetovanEnemy().getY());
    }

    private int resetCounter(int counter) {
        if (counter > 5) {
            return 5;
        }
        return counter;
    }
}
