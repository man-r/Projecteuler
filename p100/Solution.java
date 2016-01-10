import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    double n = Double.parseDouble(args[0]);

    boolean found = false;
    for (double i = n; !found; i++) {
      for (int j = 1; j < i; j++) {
        double blue = j;
        double red = i - j;

        double bb = (blue/i) * ((blue -1) / (i-1));
        if (bb == 0.5) {
          System.out.println("blue is: " + blue);
          System.out.println("total is: " + i);
          found = true;
        }
      }

    }
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
