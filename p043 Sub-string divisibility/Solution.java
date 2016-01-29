import java.util.*;
import java.io.*;
import java.math.*;
class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    boolean found = false;

    BigInteger sum = BigInteger.ZERO;
    for (BigInteger i = new BigInteger("1023456789"); i.min(new BigInteger("9876543210")).equals(i); i = i.add(BigInteger.ONE)) {
      char[] p = i.toString().toCharArray();
      if (isPandigital(p)) {
        if (p[5]=='0' || p[5] == '5') {
          System.out.println(i + " isPandigital - SUM IS: " + sum);
          int d24 = Integer.parseInt(i.toString().substring(1, 4));
          int d35 = Integer.parseInt(i.toString().substring(2, 5));
          int d46 = Integer.parseInt(i.toString().substring(3, 6));
          int d57 = Integer.parseInt(i.toString().substring(4, 7));
          int d68 = Integer.parseInt(i.toString().substring(5, 8));
          int d79 = Integer.parseInt(i.toString().substring(6, 9));
          int d80 = Integer.parseInt(i.toString().substring(7, 10));

          if (d24%2==0 && d35%3==0 && d46%5==0 && d57%7==0 && d68%11==0 && d79%13==0 && d80%17==0) {
            sum = sum.add(i);
          }
        }

      }
    }

    System.out.println(sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static boolean isPandigital(char[] pandigital) {
    Arrays.sort(pandigital);
    for (int i = 0; i < pandigital.length; i++) {
      if (Character.getNumericValue(pandigital[i]) != i) {
        return false;
      }
    }


    return true;
  }
}
