import java.util.*;
import java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    System.out.println("largest factor: " + getLargestFactor(new BigInteger(args[0])));
    System.out.println("largest factor: " + getLargestFactor(Integer.parseInt(args[0])));
  }

  static int getLargestFactor(int num) {

    int largestFactor = -1;

    if (isPrime(num)) {
      largestFactor = num;
    }

    else {
      for (int i = 2; i < num/2 && largestFactor == -1; i++) {

        if (isPrime(i) && num % i == 0) {
            largestFactor = i;
        }
      }

      int largestFactor2 = getLargestFactor(num/largestFactor);
      if (largestFactor2 > largestFactor) {
        largestFactor = largestFactor2;
      }
    }

    return largestFactor;
  }


  static BigInteger getLargestFactor(BigInteger num) {

    BigInteger largestFactor = BigInteger.ONE;

    if (isPrime(num)) {
      largestFactor = num;
    }

    else {

      BigInteger i = new BigInteger("2");
      BigInteger max = num.divide(i);

      while(i.min(max).equals(i) && largestFactor.equals(BigInteger.ONE)) {

        if (isPrime(i) && num.mod(i).equals(BigInteger.ZERO)) {
          largestFactor = i;
        }
        i = i.add(BigInteger.ONE);
      }

      BigInteger largestFactor2 = getLargestFactor(num.divide(largestFactor));
      if (largestFactor.min(largestFactor2).equals(largestFactor)) {
        largestFactor = largestFactor2;
      }
    }

    return largestFactor;
  }


  static boolean isPrime(int p) {
    for (int i = 2; i <= p/2; i++) {
      if (p % i == 0) {
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
