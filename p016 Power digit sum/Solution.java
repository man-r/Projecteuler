import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    BigInteger no = new BigInteger(args[0]);
    int pow = Integer.parseInt(args[1]);

    BigInteger digits = no.pow(pow);

    int sum = 0;


    while(digits.max(BigInteger.ONE).equals(digits)) {
      sum += Integer.parseInt(digits.mod(BigInteger.TEN).toString());
      digits = digits.divide(BigInteger.TEN);
    }



    System.out.println("the number is : " + no.pow(pow).toString() );
    System.out.println("the number digits sum is : " + sum );

    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
