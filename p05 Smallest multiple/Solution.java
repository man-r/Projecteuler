import 	java.math.BigInteger;
import java.util.*;

class Solution {
  public static void main(String[] args) {

    BigInteger bigMin = new BigInteger(args[0]);
    BigInteger bigMax = new BigInteger(args[1]);

    int min = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);

    int smallest = 1;
    ArrayList<Integer> primes = new ArrayList<Integer>();
    ArrayList<Integer> powers = new ArrayList<Integer>();


    for (int i = min; i <= max; i++) {
      if (isPrime(i)) {
        primes.add(i);
        powers.add(1);
      }
    }

    for (int i = min; i <= max; i++) {
      if (!isPrime(i)) {
        for (int j = 0; j < primes.size(); j++) {
          if (i % primes.get(j) == 0) {
            int count = 0;
            int temp = i;
            for (int t = 0; temp % primes.get(j) == 0; t++) {
              temp = temp/primes.get(j);
              count++;
            }

            if (count > powers.get(j)) {
              powers.set(j, count);
            }

          }
        }
      }
    }

    for (int i = 0; i < primes.size(); i++) {
      smallest = smallest * (int)(Math.pow(primes.get(i), powers.get(i)));
    }
    System.out.println("The araylist contains the following elements: " + primes);
    System.out.println("The araylist contains the following elements: " + powers);

    System.out.println("smallest: " + smallest);

  }

  static boolean isPrime(int p) {
    if (p == 1) {
      return false;
    }
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
