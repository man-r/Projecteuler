import java.util.*;
import java.io.*;
import java.math.*;
class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    boolean found = false;

    BigInteger p = new BigInteger(args[0]);

    while (!found) {
      p = p.subtract(BigInteger.ONE);

      if (isPandigital(p.toString().toCharArray())) {
        System.out.println(p);
        if (isPrime(p)) {
          found = true;
        }
      }
    }

    System.out.println(p);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static boolean isPandigital(char[] pandigital) {
    Arrays.sort(pandigital);
    for (int i = 1; i <= pandigital.length; i++) {
      if (Character.getNumericValue(pandigital[i-1]) != i) {
        return false;
      }
    }


    return true;
  }

  static boolean isPrime(BigInteger p) {

    BigInteger i = new BigInteger("2");
    BigInteger max = p.divide(i);

    while(i.min(max).equals(i)) {
      if (p.mod(i).equals(BigInteger.ZERO)) {
        return false;
      }

      i = i.add(BigInteger.ONE);
    }
    return true;
  }
}
