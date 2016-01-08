import java.util.*;
import java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int []result ={1,1};

    for (int i = 10; i < 100; i++) {
      for (int j = 10; j < 100 ; j++) {
        int [] a = {i/10, i%10};
        int [] b = {j/10, j%10};

        if (i != j && a[1] != 0 && b[1] != 0 && a[0] != a[1] && j > i) {
          int[] curious = {0,0};
          if (a[0] == b[0] && b[1] != 0) {
            curious[0] = a[1];
            curious[1] = b[1];
          } else if (a[1] == b[1] && b[0] != 0) {
            curious[0] = a[0];
            curious[1] = b[0];
          } else if (a[0] == b[1]  && b[0] != 0) {
            curious[0] = a[1];
            curious[1] = b[0];
          } else if (a[1] == b[0] && b[1] != 0) {
            curious[0] = a[0];
            curious[1] = b[1];
          }

          if ((double)curious[0]/curious[1] == (double)i/j) {
            System.out.println(i + "/" + j + " - " + curious[0] + "/" + curious[1]);
            curious = simplestForm(curious);
            result[0] *= i;
            result[1] *= j;
          }
        }
      }
    }

    result = simplestForm(result);


    System.out.println(Arrays.toString(result));
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int[] simplestForm(int[] f) {
    int i = 2;
    while (i <= f[0]) {
      if (f[0] % i == 0  && f[1] % i == 0) {
        f[0] /= i;
        f[1] /= i;
      } else {
        i++;
      }
    }

    return f;
  }
}
