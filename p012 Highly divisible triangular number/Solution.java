import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int divisors = Integer.parseInt(args[0]);

    BigInteger traNumber = BigInteger.ONE;
    for (BigInteger i = new BigInteger("2"); divisorsCount(traNumber) <= divisors; ) {
      traNumber = traNumber.add(i);
      i = i.add(BigInteger.ONE);
    }

    System.out.println(traNumber);

    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("totalTime: " + totalTime + " milliseconds");
  }

  static int divisorsCount(BigInteger traNumber) {
    int result = 0;
    BigInteger max = traNumber.divide(new BigInteger("2"));
    //ArrayList<BigInteger> divisors = new ArrayList<BigInteger>();
    Set<BigInteger> divisors=new TreeSet<BigInteger>();
    for (BigInteger i = BigInteger.ONE; i.min(max).equals(i);) {
      if (traNumber.mod(i).equals(BigInteger.ZERO)) {
        divisors.add(i);
        divisors.add(traNumber.divide(i));
      }
      i = i.add(BigInteger.ONE);
    }

    return divisors.size();
  }
}
