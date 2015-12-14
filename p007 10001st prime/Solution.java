import 	java.math.BigInteger;
import java.util.*;


class Solution {

  public static void main(String[] args) {
    int num  = Integer.parseInt(args[0]);

    BigInteger i = BigInteger.ONE;

    while(num > 1) {
      i = i.add(BigInteger.ONE);
      i = i.add(BigInteger.ONE);
      if(isPrime(i)){
        num--;
      }
    }

    System.out.println("the number is : " + i.toString());

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
