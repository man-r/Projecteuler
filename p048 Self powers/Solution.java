import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    BigInteger sum = BigInteger.ZERO;

    for (int i = 1; i <= 1000; i++) {
      BigInteger temp = new BigInteger("" + i);
      sum = sum.add(temp.pow(i));
    }

    System.out.println(sum.toString());
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
