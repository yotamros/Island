/*
 * The purpose of this program is to find out how many islands are in a given
 * set of a 2d array of booleans.  True signifies an island and false is  
 * an ocean.  Two squares are considered to be part of the same island if 
 * they touch one another, including diagonally.  
 */

import java.util.ArrayList;

public class Island {

    boolean[][] map;
    ArrayList<ArrayList<Integer>> allIslands = new ArrayList<ArrayList<Integer>>();
    private static final int MAP_SIZE = 10;

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
     * Prints out the details of each island. i.e which points are included in 
     * each island. 
     */
    private void islandsStats() {
        System.out.println("there are " + allIslands.size() + " islands.");
        for (int i = 0; i < allIslands.size(); i++) {
            System.out.println("Island #" +(i+1) + " includes points: " + allIslands.get(i));
        }
    }

    /**
     * Goes through each point of the 2d map array.  When the inspected point is
     * an island (true) checks to see if the point is already a part of any 
     * found island.  If it is not, creates a new island and in a recursive 
     * fashion checks to see if any of the neighboring points are an island.  If
     * they are, adds these points to the same island.    
     */
    private void findIsland() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]) {
                    int point = i * 10 + (j);
                    if (!isPointListed(point)) {
                        ArrayList<Integer> island = createIsland(point);
                        findNeighbors(i, j, island);
                    }
                }
            }
        }
    }
    
    /**
     * Gets a point and finds out if any of the neighboring squares are islands.
     * If neighboring islands are found they are added to the island of the 
     * point and continue the search in a recursion.  
     * @param, row, int, the row index of the point to inspect. 
     * @param, col, int, the col index of the point to inspect. 
     * @param ArrayList<Integer>, island, the island the point belongs to.
     */
    private void findNeighbors(int row, int col, ArrayList<Integer> island) {
        // Check north.
        if (row > 0) {
            if (map[row - 1][col]) {
                int point = (row - 1) * 10 + (col);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newRow = row - 1;
                    findNeighbors(newRow, col, island);
                }
            }
        }
        // Check east.
        if (col < map[0].length - 1) {
            if (map[row][col + 1]) {
                int point = row * 10 + (col + 1);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newCol = col + 1;
                    findNeighbors(row, newCol, island);
                }
            }
        }
        // Check west
        if (col > 0) {
            if (map[row][col - 1]) {
                int point = row * 10 + (col - 1);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newCol = col - 1;
                    findNeighbors(row, newCol, island);
                }
            }
        }
        // Check south
        if (row < map.length - 1) {
            if (map[row + 1][col]) {
                int point = (row + 1) * 10 + (col);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newRow = row + 1;
                    findNeighbors(newRow, col, island);
                }
            }
        }
        // Check south-west
        if (row < map.length - 1 && col > 0) {
            if (map[row + 1][col - 1]) {
                int point = (row + 1) * 10 + (col - 1);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newRow = row + 1;
                    int newCol = col - 1;
                    findNeighbors(newRow, newCol, island);
                }
            }
        }
        // Check south-east
        if (row < map.length - 1 && col < map[0].length - 1) {
            if (map[row + 1][col + 1]) {
                int point = (row + 1) * 10 + (col + 1);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newRow = row + 1;
                    int newCol = col + 1;
                    findNeighbors(newRow, newCol, island);
                }
            }
        }
        // Check north-east
        if (row > 0 && col < map[0].length - 1) {
            if (map[row - 1][col + 1]) {
                int point = (row - 1) * 10 + (col + 1);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newRow = row - 1;
                    int newCol = col + 1;
                    findNeighbors(newRow, newCol, island);
                }
            }
        }
        // Check north-west
        if (row > 0 && col > 0) {
            if (map[row - 1][col - 1]) {
                int point = (row - 1) * 10 + (col - 1);
                if (!isPointListed(point)) {
                    island.add(point);
                    int newRow = row - 1;
                    int newCol = col - 1;
                    findNeighbors(newRow, newCol, island);
                }
            }
        }
    }

    /**
     * Creates a new island, an array list of integers to hold all the points
     * that are part of the island.  Adds the first point into the island and
     * adds the island into the array of allIslands.
     * @param point, int, one of the points which belongs to the island.
     * @return ArrayList<Integer>, the island.
     */
    private ArrayList<Integer> createIsland(int point) {
        ArrayList<Integer> island = new ArrayList<Integer>();
        island.add(point);
        allIslands.add(island);
        return island;
    }

    /**
     * Runs through the arrays of all islands found so far to see if the
     * given point is already listed. 
     * @param point, the point in question.
     * @return true if the point is already in one of the island, false if not.
     */
    private boolean isPointListed(int point) {
        for (int i = 0; i < allIslands.size(); i++) {
            for (int j = 0; j < allIslands.get(i).size(); j++) {
                if (allIslands.get(i).contains(point)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Island island = new Island();
        island.createMap(MAP_SIZE);
        island.findIsland();
        island.islandsStats();
    }
}
