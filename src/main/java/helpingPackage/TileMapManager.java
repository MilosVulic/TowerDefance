package helpingPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import tiles.Tile;
import tiles.TileMap;
import tiles.TileType;

public class TileMapManager {

    // metoda za savovanje mape u fajl
    public static void saveMap(String mapName, TileMap tileMap) {
        String konacanString = getString(tileMap);
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(new File(mapName)));
            buffer.write(konacanString);
            buffer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
// metoda za numeraciju tokena koji ce da se save u fajl
    public static String getString(TileMap tileMap) {
        String konacanString = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                konacanString += getTileId(tileMap.getTile(i, j));
            }
        }
        return konacanString;
    }

    // metoda za loadovanje mapice
    public static TileMap loadMap(String mapName) {
        TileMap tileMap = new TileMap();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(mapName));
            String line = buffer.readLine();
            buffer.close();
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 20; j++) {
                    tileMap.setTile(j, i, getTileType(line.substring(i * 20 + j, i * 20 + j + 1)));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return tileMap;
    }

    // metoda za dekriptovanje vrednosti iz fajla
    public static TileType getTileType(String tip) {
        switch (tip) {
            case "0":
                return TileType.Grass;
            case "1":
                return TileType.Dirt;
            case "2":
                return TileType.Water;
            case "3":
                return TileType.LongGrass;
            default:
                break;
        }
        return null;
    }

    // metoda za enriptovanje vrednosti u fajl
    public static String getTileId(Tile tile) {
        switch (tile.getType()) {
            case Grass:
                return "0";
            case LongGrass:
                return "3";
            case Dirt:
                return "1";
            case Water:
                return "2";
            default:
                break;
        }
        return null;
    }
}
