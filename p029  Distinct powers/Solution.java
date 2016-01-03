import java.util.*;
import 	java.math.*;
import java.io.*;

class Solution {


  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    int n = Integer.parseInt(args[0]);
    int m = Integer.parseInt(args[1]);

    //ArrayList<BigInteger> powers = new ArrayList<BigInteger>();
    Set<BigInteger> powers=new TreeSet<BigInteger>();
    for (int a = n; a <= m; a++) {

      for (int b = n; b <= m; b++) {
        BigInteger x = new BigInteger("" + a).pow(b);
        powers.add(x);

      }
    }
    System.out.println(powers.size());
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
