import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);

    ArrayList<Integer> amicableNumbers = new ArrayList<Integer>();
    int sum = 0;

    for (int i=0; i <= n; i++) {


      if (!amicableNumbers.contains(i)) {
        int x = isAmicable(i);

        if (x != -1 && x != i) {
            amicableNumbers.add(i);
            amicableNumbers.add(x);

            sum += i;
            sum += x;
        }

      }
    }

    System.out.println("The arraylist contains the following elements: " + amicableNumbers);
    System.out.println("The arraylist sum: " + sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int isAmicable(int a) {

    int aSOD = sumOfDevisors(a);
    int bSOD = sumOfDevisors(aSOD);

    if (a == bSOD) {
      return aSOD;
    } else
    return  -1;
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
