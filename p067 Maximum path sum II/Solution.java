import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    String line;
    ArrayList<String> al = new ArrayList<String>();
    try {
      FileInputStream fs = new FileInputStream("triangle.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(fs));

      line = br.readLine();
      while(line != null) {
        al.add(line);
        line = br.readLine();
      }
      br.close();


    } catch (Exception e) {

    }

    int [][] triangle = new int[al.size()][al.size()];
    for (int i = 0; i < al.size(); i++) {
      String l = al.get(i);
      for (int j = 0; j <= i; j++) {
        triangle[i][j] = Integer.parseInt(l.substring(3 * j, 3 * j + 2));
      }
    }

    int []largest = new int[triangle.length];
    for (int i = 0; i < triangle.length; i++) {
      largest[i] = triangle[triangle.length - 1][i];
    }

    for (int i = triangle.length - 2; i > -1; i--) {
      for (int j = 0; j <=i; j++) {
        if (largest[j] > largest[j + 1]) {
          largest[j] = triangle[i][j] + largest[j];
        } else {
          largest[j] = triangle[i][j] + largest[j + 1];
        }

      }
    }

    System.out.println(largest[0]);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int brutForce(int[][] tree, int row, int col) {
    if (row == tree.length - 1) {
      return tree[row][col];
    }

    int right = tree[row][col] + brutForce(tree, 1+row, 1+col);
    int left  = tree[row][col] + brutForce(tree, 1+row, col);

    if (right > left) {
      return right;
    }

    return left;

  }
}