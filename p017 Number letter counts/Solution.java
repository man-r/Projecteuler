import java.util.*;
import 	java.math.BigInteger;

class Solution {

  final static String ONE = "ONE";
  final static String TWO = "TWO";
  final static String THREE = "THREE";
  final static String FOUR = "FOUR";
  final static String FIVE = "FIVE";
  final static String SIX = "SIX";
  final static String SEVEN = "SEVEN";
  final static String EIGHT = "EIGHT";
  final static String NINE = "NINE";

  final static String TEN = "TEN";
  final static String ELEVEN = "ELEVEN";
  final static String TWENTY = "TWENTY";
  final static String THIRTY = "thirty";
  final static String FIFTY = "FIFTY";
  final static String SIXTY = "SIXTY";
  final static String SEVENTY = "SEVENTY";
  final static String EIGHTY = "EIGHTY";
  final static String NINETY = "NINETY";

  final static String HUNDRED = "hundred";

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int n = Integer.parseInt(args[0]);

    String letters = toLetters(n);

    System.out.println("letters: " + letters);
    System.out.println("length: " + letters.length());
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static String toLetters(int n) {

    return "";
  }
}
