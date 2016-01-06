import java.util.*;
import 	java.math.*;
import java.io.*;

class Solution {


  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    //int n = Integer.parseInt(args[0]);

    // int[] cof = new int[8];
    // int[] weight = {1,2,5,10,20,50,100,200};

    int sum = 0;
    for (int h = 0; h <= 1; h++) {
      for (int g = 0; g <= 2; g++) {
        for (int f = 0; f <= 4; f++) {
          for (int e = 0; e <= 10; e++) {
            for (int d = 0; d <= 20; d++) {
              for (int c = 0; c <= 40; c++) {
                for (int b = 0; b <= 100; b++) {
                  for (int a = 0; a <= 200; a++) {
                    if (coinSums(a,b,c,d,e,f,g,h) == 200) {
                      System.out.println(a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h );
                      sum++;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println(sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int coinSums(int a, int b, int c, int d, int e, int f, int g, int h) {

    int sum = a*1 + b*2 + c*5 + d*10 + e*20 + f*50 + g*100 + h*200;

    return sum;
  }
}
