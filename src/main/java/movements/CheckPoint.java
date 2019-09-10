package movements;

import tiles.Tile;

public class CheckPoint {

    private Tile tile;
    private int xosa;
    private int yosa;

    /* Pomocna klasa koja sadrzi 3 vrednosti
    Tile koji definise taj checkPoint
    vrednost za x i vrednost za y. 
    Vrendosti za x i y se krecu od -1 do 1 u zavisnoti od toga kako se krece zombi.    
     */
    public CheckPoint(Tile tile, int xosa, int yosa) {
        this.tile = tile;
        this.xosa = xosa;
        this.yosa = yosa;
    }

    public Tile getTile() {
        return tile;
    }

    public int getXosa() {
        return xosa;
    }

    public int getYosa() {
        return yosa;
    }
}
