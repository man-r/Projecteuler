import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);

    ArrayList<Integer> factorials = new ArrayList<Integer>();
    factorials.add(1);
    int f = 1;
    for (int i = 1; i < 10; i++) {
      f *= i;
      factorials.add(f);
    }

    System.out.println(factorials);
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    for (int i = 3; i < n; i++) {
      int x = i;
      int sum = 0;
      while(x >= 1) {
        sum += factorials.get(x%10);
        x = x/10;
      }

      if (sum == i) {
        numbers.add(i);
      }
    }


    System.out.println(numbers);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int factorial(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    int f = 1;
    for (int i = n; i > 0; i--) {
      f *=i;
    }

    return f;
  }
}
