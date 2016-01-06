

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int sum = 0;

    for (int i = 1; i < 1000000; i++) {
      if (isPalindromes(toBinary(i)) && isPalindromes(""+i)) {
        sum += i;
      }
    }
    System.out.println(sum);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static String toBinary(int x) {
    String b = "";

    while(x/2 > 0) {
      b = x%2 + b;
      x /= 2;
    }

    b = x%2 + b;

    return b;
  }

  static boolean isPalindromes(String x) {
    String s1 = x + "";
    String s2 = "";

    while(s1.length() > s2.length()) {
      s2 = s2 + x.substring(x.length()-1);
      x = x.substring(0, x.length() -1);
      s1 = x + "";
    }

    if (s2.length() > s1.length()) {
      s2 = s2.substring(0, s2.length()-1);
    }

    if (s1.equals(s2)) {
      return true;
    }

    return false;
  }
}
