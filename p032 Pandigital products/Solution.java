import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int n = Integer.parseInt(args[0]);
    n = 9;

    int sum = 0;

    ArrayList<Integer> pandigital = new ArrayList<Integer>();
    for (int i = 1; i < 2000; i++) {
      for (int j = i+1; j < 2000; j++) {
        if (isPandigital(i, j, i*j) && !pandigital.contains(i*j)) {
          System.out.println(i + " X " + j + " = " + i*j);
          pandigital.add(i*j);
          sum += (i*j);
        }
      }

    }
    System.out.println(sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static boolean isPandigital(int a, int b, int c) {
    char[] pandigital = (a + "" + b + "" + c).toCharArray();
    if (pandigital.length != 9) {
      return false;
    }

    for (int i = 0; i < pandigital.length; i++) {
      if (pandigital[i] == '0') {
        return false;
      }
      for (int j = i + 1; j < pandigital.length; j++) {
        if (pandigital[i] == pandigital[j]) {
          return false;
        }
      }
    }
    return true;
  }
}
