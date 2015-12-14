import java.util.*;

class Solution {

  public static void main(String[] args) {
    int sum = 1000;

    int product = -1;


    for (int a = 0; product == -1 && a <= sum; a++) {

      for (int b = a + 1; product == -1 && b <= sum; b++) {

        for (int c = b + 1; product == -1 && (a + b + c) <= sum; c++) {

          if (a + b + c == sum) {

            if (Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow((1000 - a - c) , 2))) {
              System.out.println("a = " + a);
              System.out.println("b = " + b);
              System.out.println("c = " + c);

              product = a * b * c;

              System.out.println("product = " + product);
            }

          }

        }
      }
    }
  }
}
