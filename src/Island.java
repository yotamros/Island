/*
 * The purpose of this program is to find out how many islands are in a given
 * set of a 2d array of booleans.  True signifies an island and false is  
 * an ocean.  Two squares are considered to be part of the same island if 
 * they touch one another, including diagonally.  
 */

public class Island {

    boolean[][] map;
    private static final int MAP_SIZE = 6;
    int numOfIslands;

    /**
     * Creates and prints a new map of islands.
     * @param, size, int, the size of the squared world.
     */
    private void createMap(int size) {
        MapMaker newMap = new MapMaker(size);
        map = newMap.makeMap();
        newMap.printMap();
    }

    /**
     * Goes through each point of the 2d map array. When the inspected point is
     * an island (true) turns it into false so that it won't be inspected again
     * in the future.  Checks to see if there are any neighboring points which
     * are islands too.  
     * @return NumOfIslands, int, the number of islands in the map.
     */
    private int countIslands() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]) {
                    map[i][j] = false;
                    findNeighbors(i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    /**
     * Recursive method which gets a coordinate and checks if there any neighboring 
     * islands next to it.  Each time it finds an island it turns it into false
     * so that this point won't be inspected again in the future. 
     * @param row, int, the x coordinate of the point to inspect.
     * @param col, int, the y coordinate of the point to inspect.
     */
    private void findNeighbors(int row, int col) {
        // Check east.
        if (col < map[0].length - 1) {
            if (map[row][col + 1]) {
                map[row][col + 1] = false;
                findNeighbors(row, col + 1);
            }
        }
        // Check south
        if (row < map.length - 1) {
            if (map[row + 1][col]) {
                map[row + 1][col] = false;
                findNeighbors(row + 1, col);
            }
        }
        // Check west
        if (col > 0) {
            if (map[row][col - 1]) {
                map[row][col - 1] = false;
                findNeighbors(row, col - 1);
            }
        }
        // Check north.
        if (row > 0) {
            if (map[row - 1][col]) {
                map[row - 1][col] = false;
                findNeighbors(row - 1, col);
            }
        }
        // Check south-west
        if (row < map.length - 1 && col > 0) {
            if (map[row + 1][col - 1]) {
                map[row + 1][col - 1] = false;
                findNeighbors(row + 1, col - 1);
            }
        }
        // Check south-east
        if (row < map.length - 1 && col < map[0].length - 1) {
            if (map[row + 1][col + 1]) {
                (map[row + 1][col + 1]) = false;
                findNeighbors(row + 1, col + 1);
            }
        }
        // Check north-east
        if (row > 0 && col < map[0].length - 1) {
            if (map[row - 1][col + 1]) {
                map[row - 1][col + 1] = false;
                findNeighbors(row - 1, col + 1);
            }
        }
        // Check north-west
        if (row > 0 && col > 0) {
            if (map[row - 1][col - 1]) {
                map[row - 1][col - 1] = false;
                findNeighbors(row - 1, col - 1);
            }
        }
    }

    public static void main(String[] args) {
        Island island = new Island();
        island.createMap(MAP_SIZE);
        int islandsCount = island.countIslands();
        System.out.println("There are " + islandsCount + " islands.");
    }
}
