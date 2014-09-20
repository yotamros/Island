import java.util.Random;

public class MapMaker {
    
    private static final int worldSize = 5;
    boolean[][] map;
    Random rand = new Random();
    
    public boolean[][] makeMap() {
        map = new boolean[worldSize][worldSize];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = rand.nextBoolean();
//                map[0][0] = true;
//                map[0][1] = false;
//                map[0][2] = true;
//                map[1][0] = false;
//                map[1][1] = false;
//                map[1][2] = false;
//                map[2][0] = false;
//                map[2][1] = false;
//                map[2][2] = false;
            }
        }
        return map;
    }
    
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
