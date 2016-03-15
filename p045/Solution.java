import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    long t = 2;
    long p = 2;
    long h = 2;

    boolean found = false;

    for (; !found; t++) {
      BigInteger triangle = new BigInteger("" + t * ( t + 1 ) / 2);
      BigInteger pentagon = new BigInteger("" + p * ( ( 3 * p ) - 1 ) /2);
      BigInteger hexagon  = new BigInteger("" + h * ( ( 2 * h ) - 1 ));

      System.out.println("triangle : " + triangle + " t: " + t + "  p: " + p + "  h: " + h);

      for (; !found && (pentagon.min(triangle).equals(pentagon) || pentagon.equals(triangle)); p++) {
        pentagon = new BigInteger("" + p * ( ( 3 * p ) - 1 ) /2);
        System.out.println("pentagon : " + pentagon  + " t: " + t + "  p: " + p + "  h: " + h);

        for (; !found && pentagon.equals(triangle) && (hexagon.min(pentagon).equals(hexagon) || hexagon.equals(pentagon)); h++) {
          hexagon  = new BigInteger("" + h * ( ( 2 * h ) - 1 ));
          System.out.println("hexagon : " + hexagon  + " t: " + t + "  p: " + p + "  h: " + h);

          if (hexagon.equals(pentagon)) {
            System.out.println(hexagon);
            found = true;
          }
        }
      }
    }

    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
