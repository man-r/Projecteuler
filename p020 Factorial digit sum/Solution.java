import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);

    BigInteger factorial = BigInteger.ONE;

    for (int i = n; i > 0; i--) {
      factorial = factorial.multiply(new BigInteger(""+i));
    }

    System.out.println(n + "! is : " + factorial.toString());
    long result = 0;

    while(factorial.max(BigInteger.ONE).equals(factorial)) {
      result += factorial.mod(BigInteger.TEN).longValue();
      factorial = factorial.divide(BigInteger.TEN);
    }

    System.out.println("factorial digit sum is: " + result);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
