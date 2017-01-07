import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    BigInteger odd = new BigInteger("1");
    BigInteger prime = new BigInteger("2");
    BigInteger square = new BigInteger("1");

    BigInteger two = new BigInteger("2");

    boolean found = false;

    while(!found) {
      
      // if the odd is prime do not rest
      if (isPrime(odd)) {
        odd = odd.add(two);
        continue;
      }

      BigInteger test = prime.add(two.multiply(square.multiply(square)));
      

      if (test.equals(odd)) { //the proposal is true

        System.out.println(odd.toString() + " = " + prime.toString() + " + 2 X (" + square + " x " + square + ")" );
        odd = odd.add(two);
        prime = new BigInteger("2");
        square = new BigInteger("1");
        
        continue;

      } else if (test.max(odd).equals(test)) { //test is bigger than the odd 
        
        square = new BigInteger("1");


        if (prime.equals(two)) {
          prime = prime.subtract(BigInteger.ONE);
        }
        prime = prime.add(two);
        

        while (!isPrime(prime)) {
          prime = prime.add(two);
        }

        
      } else { //test is smaller so just incriment the square
        square = square.add(BigInteger.ONE);
      }

      if (odd.max(prime).equals(prime)) {
        found = true;
        break;
      }


    }

    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }















  static boolean isPrime(BigInteger p) {

    BigInteger i = new BigInteger("2");
    BigInteger max = p.divide(i);

    while(i.min(max).equals(i)) {
      if (p.mod(i).equals(BigInteger.ZERO)) {
        return false;
      }

      i = i.add(BigInteger.ONE);
    }
    return true;
  }
}
