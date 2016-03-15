import java.util.*;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    ArrayList<Integer> pentagon = new ArrayList<Integer>();
    double k = 0;
    double j = 0;
    boolean found = false;
    pentagon.add(1);
    pentagon.add(5);

    for (int n = 1; !found; n++) {
      pentagon.add(((n * ((3*n) - 1))/2));
      int lastItem = pentagon.get(pentagon.size() - 1);

      for (int i = 0; !found && i < pentagon.size(); i++) {
        int sum = pentagon.get(i) + lastItem;
        int difference = lastItem - pentagon.get(i);
        if (pentagon.contains(difference)) {
          for (int m = n + 1; !found && sum >=((m * ((3*m) - 1))/2); m++) {
            if (sum == ((m * ((3*m) - 1))/2)) {
              System.out.println("Pk: " + lastItem);
              System.out.println("Pj: " + pentagon.get(i));
              System.out.println("Pk - Pj: " + difference);
              found = true;
            }
          }
        }
      }
    }
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
