import 	java.math.BigInteger;
import java.util.*;


class Solution {

  public static void main(String[] args) {
    BigInteger  num  = new BigInteger(args[0]);
    BigInteger i = BigInteger.ONE;
    BigInteger sum = BigInteger.ZERO;

    ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
    ArrayList<BigInteger> nonPrimes = new ArrayList<BigInteger>();

    nonPrimes.add(new BigInteger("1"));
    while(i.min(num).equals(i) ) {

      if (!nonPrimes.contains(i)) {

        if(isPrime(i)){
          nonPrimes.add(nonPrimes.get(nonPrimes.size() - 1).multiply(i));
          primes.add(i);
          sum = sum.add(i);
        }

      }

      i = i.add(BigInteger.ONE);
    }

    System.out.println("The arraylist contains the following elements: " + primes);
    System.out.println("the number is : " + sum.toString());

  }


  static boolean isPrime(BigInteger p) {
    if (p.equals(BigInteger.ONE) || p.equals(BigInteger.ZERO)) {
      return false;
    }
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
