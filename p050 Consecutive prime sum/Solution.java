import java.util.*;
import java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);
    ArrayList<Integer> primes = new ArrayList<Integer>();
    ArrayList<Integer> sumOfPrimes = new ArrayList<Integer>();

    primes.add(2);
    for (int i = 3; i < n; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }


    int result = 2;
    int resultCount = 0;
    for (int i = 0; i < primes.size(); i++) {
      int sum = 0;
      int count = 0;
      for (int j=i; j < primes.size() && sum < n; j++) {
        sum += primes.get(j);
        count++;
        if (isPrime(sum)) {
          sumOfPrimes.add(sum);
          if (count > resultCount) {
            result = sum;
            resultCount = count;
          }
        }
      }

    }

    Collections.sort(sumOfPrimes);
    System.out.println("prime: " + primes);
    System.out.println("prime: " + sumOfPrimes);
    System.out.println("prime: " + result);
    System.out.println("prime: " + resultCount);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
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
