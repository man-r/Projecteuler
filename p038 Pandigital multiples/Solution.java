import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int largest = 0;

    ArrayList<Integer> pandigital = new ArrayList<Integer>();
    for (int i = 1; i < (987654321/2); i++) {
      String str = "";
      for (int j = 1; str.length() < 9; j++) {
        str = str + "" + i*j;
      }

      if (isPandigital(str.toCharArray()) && Integer.parseInt(str) != i) {
        System.out.println(i + " - " + str);
        if (Integer.parseInt(str) > largest) {
            largest = Integer.parseInt(str);
        }
        // sum += (i*j);
      }

    }
    System.out.println(largest);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static boolean isPandigital(char[] pandigital) {
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
