/*
 * The purpose of this class is to create and print a map of islands, which is 
 * a 2d boolean array.  True signifies island, false sea.  The map is created
 * randomly.
 */

import java.util.Random;

public class MapMaker {
    
    private int worldSize;
    boolean[][] map;
    Random rand = new Random();
    private double density = 2;
    public MapMaker(int size) {
        worldSize = size;
    }
    
    /**
     * Creates a 2d boolean array and fills it randomly with true or false.
     * @return boolean, the map array.
     */
    public boolean[][] makeMap() {
        map = new boolean[worldSize][worldSize];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (new Random().nextDouble() <= density/10) {
                    map[i][j] = true;
                }
            }
        }
        return map;
    }
    
    /**
     * Prints the map array. 1's for true, empty space for false.  
     */
    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (j % worldSize == 0) {
                    System.out.println();
                }
                if (map[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
        }
        System.out.println();
    }
    
}
