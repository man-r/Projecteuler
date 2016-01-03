import java.util.*;
import 	java.math.*;
import java.io.*;

class Solution {

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();

    int cycle = 0;
    int d = 0;
    for (int i = 1; i < 1000; i++) {
      int tempCycle = recipocalCycleCount(i);

      if (tempCycle > cycle) {
        cycle = tempCycle;
        d = i;
      }

      System.out.println(i + " - " + tempCycle + " ------ " + cycle + " (" + d + ")");
    }

    System.out.println(d);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int recipocalCycleCount(int d) {
    ArrayList<Integer> c = new ArrayList<Integer>();

    int rem = 1;

    for (int i = 0; i < 1000; i++) {
      rem *= 10;
      rem %= d;
      if (c.contains(rem)) {
        i = 1000;
      } else {
        c.add(rem);
      }
    }
    return c.size();
  }

}
