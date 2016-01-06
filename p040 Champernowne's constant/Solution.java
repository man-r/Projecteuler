import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    //int n = Integer.parseInt(args[0]);

    int result = 1;

    String irr  = "";
    for (int i = 0; irr.length() <= 1000000; i++) {
      irr = irr + i;
    }

    for (int i = 1; i <= 1000000; i*=10) {
      result *= Integer.parseInt("" + irr.charAt(i));
    }

    System.out.println(result);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
