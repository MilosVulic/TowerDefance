package tiles;

import helpingPackage.StartingUtility;
import static helpingPackage.StartingUtility.drawingTextureSquares;

public class TileMap {

    private final Tile[][] map;

    public TileMap(Tile[][] map) {
        this.map = map;
    }

    public TileMap() {
        map = new Tile[15][20];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Tile(j * StartingUtility.SQUARE_SIZE, i * StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, TileType.Grass);
            }
        }
    }

    public TileMap(int[][] againMap) {
        map = new Tile[15][20];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (againMap[i][j]) {
                    case 0:
                        map[i][j] = new Tile(j * StartingUtility.SQUARE_SIZE, i * StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, TileType.Grass);
                        break;
                    case 1:
                        map[i][j] = new Tile(j * StartingUtility.SQUARE_SIZE, i * StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, TileType.Dirt);
                        break;
                    case 2:
                        map[i][j] = new Tile(j * StartingUtility.SQUARE_SIZE, i * StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, TileType.Water);
                        break;
                    case 3:
                        map[i][j] = new Tile(j * StartingUtility.SQUARE_SIZE, i * StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, TileType.LongGrass);
                        break;
                    default:
                        map[i][j] = new Tile(j * StartingUtility.SQUARE_SIZE, i * StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, TileType.Grass);
                        break;
                }
            }
        }
    }

    public void drawTiles() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Tile tile = map[i][j];
                drawingTextureSquares(tile.getTexture(), tile.getX(), tile.getY(), tile.getWidth(), tile.getHeigth());
            }
        }
    }

    public void setTile(int x, int y, TileType type) {
        map[y][x] = new Tile(x * StartingUtility.SQUARE_SIZE, y * StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, StartingUtility.SQUARE_SIZE, type);
    }

    public Tile getTile(int x, int y) {
        if (x < 15 && y < 20 && x > -1 && y > -1) {
            return map[x][y];
        } else {
            return new Tile(0, 0, 0, 0, TileType.Water);
        }
    }
}
