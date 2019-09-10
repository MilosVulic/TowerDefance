package tiles;

public enum TileType {

    Grass("grass", true),
    Water("water", false),
    LongGrass("longGrass", false),
    Dirt("dirt", false),
    Test("test", false);

    String tip;
    boolean buildable;

    TileType(String tip, boolean buildable) {
        this.tip = tip;
        this.buildable = buildable;
    }
}
