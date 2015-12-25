import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    ArrayList<Integer> abundants = new ArrayList<Integer>();
    ArrayList<Integer> sumOfTwoAbundants = new ArrayList<Integer>();

    long sum = 0;

    for (int i = 0; i <28123; i++) {
      //sumOfTwoAbundants.add(i);
      if (sumOfDevisors(i) > i) {
          abundants.add(i);
      }
    }

    for (int i = 0; i <28123; i++) {
      for (int j = 0; j < abundants.size(); j++) {
        if (i < abundants.get(j)) {
          sum += i;
          break;
        }
        if (abundants.contains(i - abundants.get(j))) {
          sumOfTwoAbundants.add(i);
          break;
        }
      }
    }

    System.out.println("The sum: " + sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }





  static int sumOfDevisors(int a) {
    int sum  = 0;

    for (int i = 1; i <= a/2; i++) {
      if (a % i == 0) {
        sum += i;
      }
    }

    return sum;
  }
}
