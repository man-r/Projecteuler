import java.util.*;

class Solution {

  public static void main(String[] args) {
    int num = Integer.parseInt(args[0]);

    ArrayList<Integer> factors = new ArrayList<Integer>();

    if (!isPrime(num)) {
      if (num % 2 == 0) {
        factors.add(2);
      }
      for (int i = 3; i <= num/2; i+=2) {
        if (isPrime(i)) {
          if (num % i == 0) {
            factors.add(i);
          }
        }
      }
    }
    // Display the contents of the array list
    System.out.println("The arraylist contains the following elements: " + factors);
  }


  static boolean isPrime(int p) {
    for (int i = 2; i <= p/2; i++) {
      if (p % i == 0) {
        System.out.println("not prime");
        return false;
      }
    }

    return true;
  }

}
