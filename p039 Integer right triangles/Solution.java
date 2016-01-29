import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int[] pCount = new int[1000];

    for (int a = 1; a < 500; a++) {
      String str = "";
      for (int b = 1; b < 500; b++) {
        int c = (int)Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
        if (Math.pow(c, 2) == (Math.pow(a,2) + Math.pow(b, 2))) {
          int p = a + b + c;

          if (p <= 1000) {
            pCount[p-1]++;
          }
        }

      }
    }

    int largest = 0;
    for (int i = 1; i < pCount.length; i++) {
      if (pCount[i] > pCount[largest]) {
        largest = i;
      }
    }
    System.out.println(Arrays.toString(pCount));
    System.out.println(largest);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
