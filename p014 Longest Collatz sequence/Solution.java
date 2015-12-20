import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    BigInteger start = new BigInteger(args[0]);

    int count = 0;
    BigInteger result = BigInteger.ZERO;

    ArrayList<BigInteger> nList = new ArrayList<BigInteger>();
    ArrayList<Integer> nChain = new ArrayList<Integer>();

    for (BigInteger i = start; !i.equals(BigInteger.ONE); ) {

      int tempCount = 0;
      ArrayList<BigInteger> tList = new ArrayList<BigInteger>();
      ArrayList<Integer> tChain = new ArrayList<Integer>();

      BigInteger n = i;


      while (!n.equals(BigInteger.ONE)) {
        // if (nList.contains(n)) {
        //   tempCount += nChain.get(nList.indexOf(n));
        //   n = BigInteger.ONE;
        // } else {
        //   n = nextCollatz(n);
        //   tempCount++;
        // }

        n = nextCollatz(n);
        tempCount++;
      }

      // nList.add(i);
      // nChain.add(tempCount);
      //
      // for (int t = 0; t < tChain.size(); t++) {
      //   if (!nList.contains(tList.get(t))) {
      //     nList.add(tList.get(t));
      //     nChain.add(tChain.get(t));
      //   }
      // }

      if (tempCount > count) {
        count = tempCount;
        result = i;
      }

      //System.out.println(i.toString() + " - " + tempCount + " - " + count + " ==> " + result.toString());

      i = i.subtract(BigInteger.ONE);
    }

    //System.out.println("The arraylist contains the following elements: " + nList);

    System.out.println("maximum number of count is : " + count);
    System.out.println("the number is : " + result.toString() );

    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int nextCollatz(int n) {

    if (n % 2 == 0) {
      n = n/2;
    } else {
      n = 3*n;
      n++;
    }
    return n;
  }

  static BigInteger nextCollatz(BigInteger n) {
    if (n.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
      n = n.divide(new BigInteger("2"));
    } else {
      n = n.multiply(new BigInteger("3"));
      n = n.add(BigInteger.ONE);
    }
    return n;
  }
}
