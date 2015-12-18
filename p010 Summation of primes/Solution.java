import 	java.math.BigInteger;
import java.util.*;


class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int  num  = Integer.parseInt(args[0]);
    ArrayList<Integer> primes = new ArrayList<Integer>();
    double sum = 0;

    for (int i = 0; i < num; i++) {
      if (isPrime(i, primes)) {
        primes.add(i);
        sum = sum + i;
      }
    }

    System.out.println("The arraylist contains the following elements: " + primes);
    System.out.println("the number is : " + sum);
    System.out.printf("dexp: %.0f\n", sum);

    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("totalTime: " + totalTime + " milliseconds");
  }

  static boolean isPrime(int p) {
    for (int i = 2; i <= Math.sqrt(p); i++) {
      if (p % i == 0) {
        return false;
      }
    }

    return true;
  }

  static boolean isPrime(int p, ArrayList<Integer> primes) {
    if (p == 2) {
      return true;
    } else if (p < 2) {
      return false;
    }

    double max = Math.sqrt(p);
    for (int i = 0; i < primes.size() && primes.get(i) <= Math.sqrt(p); i++) {
      if (p % primes.get(i) == 0) {
        return false;
      }
    }

    return true;
  }

}
