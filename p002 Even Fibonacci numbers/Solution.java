import java.util.*;

class Solution {

  public static void main(String[] args) {
    int max = Integer.parseInt(args[0]);

    ArrayList<Integer> fibonacci = new ArrayList<Integer>();
    fibonacci.add(1);
    int result = 0;

    for (int i = 1; fibonacci.get(i-1) < max; i++) {
      if (i == 1) {
        fibonacci.add(2);
      } else {
        fibonacci.add(fibonacci.get(i-1) + fibonacci.get(i - 2));
      }

      if (fibonacci.get(i) % 2 == 0) {
        result += fibonacci.get(i);
      }
    }
    // Display the contents of the array list
    System.out.println("The arraylist contains the following elements: " + fibonacci);

    System.out.println("result: " + result);
  }

}
