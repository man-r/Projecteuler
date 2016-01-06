import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);

    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int p = 1; p < n; p++) {
      if (isPrime(p)) {
        primes.add(p);
        int current = p;
        while (rotate(current) != p) {
          current = rotate(current);
          if (!isPrime(current)) {
            primes.remove(primes.size() - 1);
            break;
          }
        }

      }
    }
    System.out.println(primes.size());
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
