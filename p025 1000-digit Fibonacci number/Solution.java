import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int n = Integer.parseInt(args[0]);

    BigInteger fibonacci1 = BigInteger.ONE;
    BigInteger fibonacci2 = BigInteger.ONE;
    BigInteger fibonacci = BigInteger.ONE;

    int i = 3;
    while (fibonacci.toString().length() < n) {
        fibonacci = fibonacci1.add(fibonacci2);

        fibonacci2 = fibonacci1;
        fibonacci1 = fibonacci;

        i++;
    }

    System.out.println("The index: " + --i);
    System.out.println("The fibonacci: " + fibonacci.toString());
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
