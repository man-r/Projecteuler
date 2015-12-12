import 	java.math.BigInteger;
import java.util.*;


class Solution {

  public static void main(String[] args) {
    BigInteger bigMin = new BigInteger(args[0]);
    BigInteger bigMax = new BigInteger(args[1]);

    int min = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);

    double sumOfSquare = 0;
    double squareOfSum = 0;

    BigInteger bigSumOfSquare = BigInteger.ZERO;
    BigInteger bigSquareOfSum = BigInteger.ZERO;

    for (int i=min; i <= max; i++) {
      sumOfSquare += Math.pow(i,2);
      squareOfSum += i;

      bigSumOfSquare = bigSumOfSquare.add(new BigInteger("" + (int)Math.pow(i,2)));
      bigSquareOfSum = bigSquareOfSum.add(new BigInteger("" + i));
    }

    squareOfSum = Math.pow(squareOfSum, 2);

    bigSquareOfSum = bigSquareOfSum.pow(2);

    System.out.println("sumOfSquare: " + sumOfSquare);
    System.out.println("squareOfSum: " + squareOfSum);

    System.out.println("sumOfSquare: " + sumOfSquare);
    System.out.println("squareOfSum: " + bigSquareOfSum.toString());

    double diff = squareOfSum - sumOfSquare;
    BigInteger bigDiff = bigSquareOfSum.subtract(bigSumOfSquare);
    System.out.println("diffrence : " + (int)diff);
    System.out.println("diffrence : " + bigDiff);
  }
}
