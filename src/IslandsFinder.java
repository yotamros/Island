import java.util.ArrayList;
import java.util.List;

public class IslandsFinder {

    List<ArrayList<int[]>> allIslands = new ArrayList<ArrayList<int[]>>();
    ArrayList<int[]> island = new ArrayList<int[]>();

    boolean[][] newMap;

    private void countIslands() {
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[0].length; j++) {
                if (newMap[i][j]) {
                    if (allIslands.isEmpty()) {
                        makeNewIsland(i, j);
                    } else {
                        if(!isNeighbor(i, j)) {
                            makeNewIsland(i, j);
                        }
                    }
                }
            }
        }
        System.out.println("There are : " + allIslands.size() + " islands.");
    }

    private void makeNewIsland(int row, int col) {
        int[] point = new int[2];
        point[0] = row;
        point[1] = col;
        island.add(point);
        allIslands.add(island);
    }

    private boolean isNeighbor(int row, int col) {
        for (int i = 0; i < allIslands.size(); i++) {
            ArrayList<int[]> islandToCheck = allIslands.get(i);
            for (int j = 0; j < islandToCheck.size(); j++) {
                int[] point = islandToCheck.get(j);
                if (point[0] == row && point[1] + 1 == col
                        || point[0] + 1 == row && point[1] == col
                        || point[0] + 1 == row && point[1] + 1 == col
                        || point[0] + 1 == row && point[1] - 1 == col
                        ) {
                    addToIsland(row, col);
                    return true;
                }
            }
        }
        return false;
    }
    
    private void addToIsland(int row, int col) {
        int[] newPoint = new int[2];
        newPoint[0] = row;
        newPoint[1] = col;
        island.add(newPoint);
    }

    private void createMap() {
        MapMaker map = new MapMaker();
        newMap = map.makeMap();
        map.printMap();
    }

    public static void main(String[] args) {
        IslandsFinder findIsland = new IslandsFinder();
        findIsland.createMap();
        findIsland.countIslands();
    }
}
