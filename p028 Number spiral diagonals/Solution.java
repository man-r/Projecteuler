import java.util.*;
import 	java.math.*;
import java.io.*;

class Solution {


  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);

    int [][] spiral = new int[n][n];

    String nextTurn = "R";

    int col = n/2;
    int row = n/2;
    spiral[row][col] = 1;
    for (int i = 2; i <= n*n; i++) {

      if (nextTurn.equals("R")) {
        if (spiral[row][col+1] == 0 && (col+1) < n) {
          spiral[row][++col] = i;
          nextTurn = "D";
        } else {
          spiral[--row][col] = i;
          nextTurn = "R";
        }
      } else if (nextTurn.equals("D")) {
        if (spiral[row + 1][col] == 0 && (row + 1) < n) {
          spiral[++row][col] = i;
          nextTurn = "L";
        } else {
          spiral[row][++col] = i;
          nextTurn = "D";
        }
      } else if (nextTurn.equals("L") && (col - 1) > -1) {
        if (spiral[row][col - 1] == 0) {
          spiral[row][--col] = i;
          nextTurn = "U";
        } else {
          spiral[++row][col] = i;
          nextTurn = "L";
        }
      } else if (nextTurn.equals("U") && (row - 1) > -1) {
        if (spiral[row - 1][col] == 0) {
          spiral[--row][col] = i;
          nextTurn = "R";
        } else {
          spiral[row][--col] = i;
          nextTurn = "U";
        }
      }
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += spiral[i][i];
      sum += spiral[i][n - i - 1];
    }
    sum -= 1;
    //System.out.println(Arrays.deepToString(spiral));
    System.out.println(sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
