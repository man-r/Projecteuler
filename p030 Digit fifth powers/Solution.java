import java.util.*;
import 	java.math.*;
import java.io.*;

class Solution {


  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);

    //int max = (int)Math.pow(100, n);

    int sum = 0;
    for (int a = 2; a < 1000000; a++) {
      if (digitPowers(a,n)) {
        System.out.println(a);
        sum += a;
      }
    }
    System.out.println(sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static boolean digitPowers(int n, int p) {
    int sum = 0;
    int x = n;
    while(x >= 1) {
      sum += (int)Math.pow((x%10), p);
      x = x/10;
    }
    //System.out.println(sum + " - " + n);
    if (sum == n) {
      return true;
    }
    return false;
  }
}
