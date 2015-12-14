import java.util.*;

class Solution  {

  public static void main(String[] args) {
    int max = Integer.parseInt(args[0]);

    int result = 0;
    for (int i = 1; (i * 3) < max; i++) {
      int mThree = i * 3;
      int mFive = i * 5;

      if (mThree < max && mThree % 5 !=0) {
        result = result + mThree;
      }

      if(mFive < max) {
        result = result + mFive;
      }
    }

    // Display the contents of the array list
    System.out.println("result: " + result);
  }

}
