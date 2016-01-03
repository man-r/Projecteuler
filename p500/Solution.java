import java.util.*;
import 	java.math.BigInteger;
import java.io.*;
class Solution {

  static BigInteger devisorsTarget = new BigInteger("2");

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    BigInteger x = BigInteger.ONE;

    ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
    try {
      BufferedReader in = new BufferedReader (new FileReader("../primes.txt"));
      String str;

      while ((str = in.readLine()) != null) {
        x = new BigInteger(str);
        primes.add(x);
      }

      System.out.println("last prime is: " + x);

    } catch (IOException e) {
      System.out.println("file not found");
    }


    devisorsTarget = devisorsTarget.pow(500500);

    if (primes.size() > 0) {
      x = x.add(BigInteger.ONE);
      x = x.add(BigInteger.ONE);
    }
    if (x.equals(new BigInteger("2"))) {
      x = x.subtract(BigInteger.ONE);
    }

    try {
      BufferedWriter out = new
      BufferedWriter(new FileWriter("../primes.txt", true));

      while(x.min(new BigInteger("50000000")).equals(x)) {
        if (isPrime(x, primes)) {
          primes.add(x);
          out.append(x.toString());
          out.newLine();
        }
        x = x.add(BigInteger.ONE);
        x = x.add(BigInteger.ONE);
      }

      out.close();
    } catch (IOException e) {
    }




    System.out.println("number of primes found: " + primes.size());



    ArrayList<BigInteger> factorsPow = new ArrayList<BigInteger>();
    BigInteger result = BigInteger.ONE;

    //devisorsTarget = new BigInteger("16");

    for (int i = 0; i < primes.size(); i++) {
      factorsPow.add(BigInteger.ZERO);
    }

    factorsPow.set(0, devisorsTarget.subtract(BigInteger.ONE));
    result = factorsProduct(primes, factorsPow);

    System.out.println("result = s^target-1: " + result.equals(pow(new BigInteger("2"), devisorsTarget)));

    // System.out.println(result);
    // System.out.println("answer modulo 500500507: " + result.mod(new BigInteger("500500507")));
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static BigInteger factorsProduct(ArrayList<BigInteger> primes, ArrayList<BigInteger> factorsPow) {
    if (primes.size() != factorsPow.size()) {
      return BigInteger.ZERO;
    }

    BigInteger product = BigInteger.ONE;

    for (int i = 0; i < primes.size(); i++) {
      product = product.multiply(pow(primes.get(i), factorsPow.get(i)));
    }

    return product;
  }

  static BigInteger pow(BigInteger base, BigInteger exponent) {
    BigInteger result = BigInteger.ONE;
    while (exponent.signum() > 0) {
      if (exponent.testBit(0)) result = result.multiply(base);
      base = base.multiply(base);
      exponent = exponent.shiftRight(1);
    }
    return result;
  }

  static BigInteger devisorsCount(BigInteger n, ArrayList<BigInteger> primes) {

    //BigInteger max = sqrt(n);
    BigInteger count = BigInteger.ZERO;
    count = count.add(BigInteger.ONE);

    BigInteger tempN = n;
    for (int i = 0; i < primes.size() && !tempN.equals(BigInteger.ONE); i++) {
      BigInteger tempC = BigInteger.ZERO;

      while(tempN.mod(primes.get(i)).equals(BigInteger.ZERO)) {
        tempN = tempN.divide(primes.get(i));
        tempC = tempC.add(BigInteger.ONE);
      }
      if (!tempC.equals(BigInteger.ZERO)) {
        tempC = tempC.add(BigInteger.ONE);
        count = count.multiply(tempC);
      }
    }
    System.out.println(" -- " + count.toString());
    return count;
  }


  static boolean isPrime(BigInteger p) {

    BigInteger i = new BigInteger("2");

    if (p.equals(BigInteger.ONE)) {
      return false;
    }

    if (p.equals(i)) {
      return true;
    }

    BigInteger max = sqrt(p);

    while(i.min(max).equals(i)) {
      if (p.mod(i).equals(BigInteger.ZERO)) {
        return false;
      }
      i = i.add(BigInteger.ONE);
    }
    return true;
  }

  static boolean isPrime(BigInteger p, ArrayList<BigInteger> primes) {

    if (p.equals(BigInteger.ONE)) {
      return false;
    }

    if (p.equals(new BigInteger("2"))) {
      return true;
    }

    BigInteger max = sqrt(p);

    for (int i = 0; i < primes.size() && primes.get(i).max(max).equals(max); i++) {
      if (p.mod(primes.get(i)).equals(BigInteger.ZERO)) {
        return false;
      }
    }
    return true;
  }

  static BigInteger sqrt(BigInteger n) {
    BigInteger a = BigInteger.ONE;
    BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
    while(b.compareTo(a) >= 0) {
      BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
      if(mid.multiply(mid).compareTo(n) > 0) {
        b = mid.subtract(BigInteger.ONE);
      } else {
        a = mid.add(BigInteger.ONE);
      }
    }
    return a.subtract(BigInteger.ONE);
  }
}
