import java.util.*;
import 	java.math.*;
import java.io.*;

class Solution {

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();

    int qpCount = 0;
    int coffProduct = 0;
    for (int b = -999; b < 1000; b++) {
      //if (isPrime(b)) {
        for (int a = -999; a < 1000; a++) {
          if (qpCount < quadraticPrimes(a, b)) {
            qpCount = quadraticPrimes(a, b);
            coffProduct = a * b;
            System.out.println("a: " + a);
            System.out.println("b: " + b);
            System.out.println("qpCount = " + qpCount);

          }
        }
      //}
    }
    System.out.println(coffProduct);
    System.out.println(quadraticPrimes(-79, 1601));
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int quadraticPrimes (int a, int b) {

    int n = 0;
    while (1 > 0) {
      int p = (n*n) + (a*n) + b;
      if (!isPrime(p)) {
        break;
      }

      n++;
    }

    return n;
  }
  static boolean isPrime(int p) {
    if (p <= 1) {
      return false;
    }
    for (int i = 2; i <= p/2; i++) {
      if (p % i == 0) {
        return false;
      }
    }

    return true;
  }

}
