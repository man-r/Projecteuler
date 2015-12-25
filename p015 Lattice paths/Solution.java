import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int gridSize = Integer.parseInt(args[0]);

    long[][] grid = new long[gridSize+1][gridSize+1];

    //Initialise the grid with boundary conditions
    for (int i = 0; i < gridSize; i++) {
      grid[i][gridSize] = 1;
      grid[gridSize][i] = 1;
    }

    for (int i = gridSize - 1; i >= 0; i--) {
      for (int j = gridSize - 1; j >= 0; j--) {
        grid[i][j] = grid[i+1][j] + grid[i][j+1];
        System.out.println("" + grid[i][j]);
      }
    }

    System.out.println("the number is : " + stepCount(0,0,gridSize) );

    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static long stepCount(int h, int w, int target) {

    if (h == target && w == target) {
      return 1;
    } else if (h == target && w < target) {
      return stepCount(h, w+1, target);
    } else if (h < target && w == target) {
      return stepCount(h+1, w, target);
    } else {
      return stepCount(h+1, w, target) + stepCount(h, w+1, target);
    }
  }
}
