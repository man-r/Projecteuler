

class Solution {

  public static void main(String[] args) {
    int digits = Integer.parseInt(args[0]);

    int min = (int)Math.pow(10, digits-1);
    int max = (int)Math.pow(10, digits) - 1;

    int palindrome = 0;
    for (int i = max; i >= min ; i--) {

      for (int j = max; j >= min; j--) {

          int x = i * j;

          if (isPalindrome(x)) {
            if (x > palindrome) {
              palindrome = x;
            }
          }
      }
    }


    System.out.println("the largest palindrome for a " + digits + " product is : " + palindrome);
  }

  static boolean isPalindrome(int x) {
    char[] chars = new char[(int) (Math.log10(x) + 1)];
    char[] rever = new char[(int) (Math.log10(x) + 1)];

    for (int i = 0; i < chars.length; i++) {
      rever[i] = (char) ('0' + (x % 10));
      chars[chars.length - i - 1] = (char) ('0' + (x % 10));
      x/=10;
    }
    boolean palindrome = true;

    for (int i=0; i < chars.length && palindrome; i++) {
      if (chars[i] != rever[i]) {
        palindrome = false;
      }
    }

    return palindrome;
  }

}
