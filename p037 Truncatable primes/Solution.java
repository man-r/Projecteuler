import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);

    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int p = 11; primes.size() < 11; p++) {
      if (isPrime(p)) {
        int left = p;
        int right = p;
        boolean truncatable = true;
        while(left >= 10 && truncatable) {
          left /= 10;
          right = Integer.parseInt((""+right).substring(1));
          if (!isPrime(left) || !isPrime(right)) {
            truncatable = false;
          }
        }

        if (truncatable) {
          primes.add(p);
        }
      }
    }
    int sum = 0;
    for (int i = 0; i < 11; i++) {
      sum += primes.get(i);
    }
    System.out.println(primes.size());
    System.out.println(sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static boolean isPrime(int p) {
    if (p == 1) {
      return false;
    }
    if (p == 2) {
      return true;
    }
    for (int i = 2; i <= p/2; i++) {
      if (p % i == 0) {
        return false;
      }
    }
    return true;
  }


  static int rotate(int x) {
    if (x < 10) {
      return x;
    }
    int p = x%10;
    x = x/10;

    return Integer.parseInt(p + "" + x);
  }
}
