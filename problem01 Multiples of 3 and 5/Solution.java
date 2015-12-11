import java.util.*;

class Solution  {

  public static void main(String[] args) {
    int max = Integer.parseInt(args[0]);
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    for (int i = 1; (i * 3) < max || (i * 5) < max; i++) {
      int mThree = i * 3;
      int mFive = i * 5;

      if (mThree < max) {
        list.add(mThree);
      }

      if(mFive < max) {
        list.add(mFive);
      }
    }

    // Display the contents of the array list
    System.out.println("The arraylist contains the following elements: " + list);
  }

}
