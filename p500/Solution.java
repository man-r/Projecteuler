import java.util.*;
import 	java.math.BigInteger;
import java.io.*;
class Solution {

  static BigInteger devisorsTarget = new BigInteger("2");

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    BigInteger i = BigInteger.ONE;

    ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
    try {
      BufferedReader in = new BufferedReader (new FileReader("../primes.txt"));
      String str;

      while ((str = in.readLine()) != null) {
        i = new BigInteger(str);
        primes.add(i);
      }

      System.out.println("last prime is: " + i);

    } catch (IOException e) {
      System.out.println("file not found");
    }


    devisorsTarget = devisorsTarget.pow(500500);

    if (primes.size() > 0) {
      i = i.add(BigInteger.ONE);
      i = i.add(BigInteger.ONE);
    }
    if (i.equals(new BigInteger("2"))) {
      i = i.subtract(BigInteger.ONE);
    }

    try {
      BufferedWriter out = new
      BufferedWriter(new FileWriter("../primes.txt", true));
      while(i.min(new BigInteger("50000000")).equals(i)) {
        if (isPrime(i, primes)) {
          primes.add(i);
          out.append(i.toString());
          out.newLine();
        }
        i = i.add(BigInteger.ONE);
        i = i.add(BigInteger.ONE);
      }

      out.close();
    } catch (IOException e) {
    }




    System.out.println("number of primes found: " + primes.size());



    BigInteger result = BigInteger.ZERO;

    //devisorsTarget = new BigInteger("16");
    i = devisorsTarget.multiply(new BigInteger("2"));

    while (result.equals(BigInteger.ZERO) ) {
      if (devisorsCount(i, primes).equals(devisorsTarget)) {
        result = i;
      }

      i = i.add(BigInteger.ONE);
      //System.out.println(i.toString());
    }

    System.out.println(result);
    System.out.println("answer modulo 500500507: " + result.mod(new BigInteger("500500507")));
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
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
