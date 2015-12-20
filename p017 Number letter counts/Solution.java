import java.util.*;
import java.math.BigInteger;

class Solution {

  final static String ZERO = "zero";
  final static String ONE = "one";
  final static String TWO = "two";
  final static String THREE = "three";
  final static String FOUR = "four";
  final static String FIVE = "five";
  final static String SIX = "six";
  final static String SEVEN = "seven";
  final static String EIGHT = "eight";
  final static String NINE = "nine";

  final static String TEN = "ten";
  final static String ELEVEN = "eleven";
  final static String TWELVE = "twelve";
  final static String THIRTEEN = "thirteen";
  final static String FOURTEEN = "fourteen";
  final static String FIFTEEN = "fifteen";
  final static String SIXTEEN = "sixteen";
  final static String SEVENTEEN = "seventeen";
  final static String EIGHTEEN = "eighteen";
  // final static String THIRTEEN = "thirteen";

  final static String TWENTY = "twenty";
  final static String THIRTY = "thirty";
  final static String FORTY = "forty";
  final static String FIFTY = "fifty";
  final static String SIXTY = "sixty";
  final static String SEVENTY = "seventy";
  final static String EIGHTY = "eighty";
  final static String NINETY = "ninety";

  final static String HUNDRED = "hundred";
  final static String THOUSAND = "thousand";

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int n = Integer.parseInt(args[0]);
    int letterCount = 0;

    for (int i = 1; i <= n; i++) {
      String letters = toLetters(i);
      System.out.println(i + ": " + letters + " - " + letters.length());

      letterCount += letters.length();
    }



    System.out.println("letterCount: " + letterCount);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static String toLetters(int n) {
    StringBuilder letter = new StringBuilder();
    for (int i = 0; n >= 1; i++) {
      int digit = n % 10;
      n /=10;
      if (i == 0) {
        letter.insert(0, oneDigitToLetter(digit));
      }

      else if (i == 1) {
        if (letter.toString().equals(ZERO)) {
          letter.delete(0, 4);
        }

        switch (digit) {
          case 0:
            if (letter.toString().length() > 0) {
              letter.insert(0, "");
            }
            break;

          case 1:
            if (letter.toString().length() == 0) {
              letter.insert(0, TEN);
            } else if (letter.toString().equals(ONE)) {
              letter.delete(0, 3);
              letter.insert(0, ELEVEN);
            } else if (letter.toString().equals(TWO)) {
              letter.delete(0, 3);
              letter.insert(0, TWELVE);
            } else if (letter.toString().equals(THREE)) {
              letter.delete(0, 5);
              letter.insert(0, THIRTEEN);
            } else if (letter.toString().equals(FIVE)) {
              letter.delete(0, 4);
              letter.insert(0, FIFTEEN);
            } else if (letter.toString().equals(EIGHT)) {
              letter.delete(0, 5);
              letter.insert(0, EIGHTEEN);
            }
            else {
              letter.append("teen");
            }
            break;

          case 2:
            letter.insert(0, TWENTY);
            break;

          case 3:
            letter.insert(0, THIRTY);
            break;

          case 4:
            letter.insert(0, FORTY);
            break;

          case 5:
            letter.insert(0, FIFTY);
            break;

          case 6:
            letter.insert(0, SIXTY);
            break;

          case 7:
            letter.insert(0, SEVENTY);
            break;

          case 8:
            letter.insert(0, EIGHTY);
            break;

          case 9:
            letter.insert(0, NINETY);
        }
      }

      else if (i == 2) {
        if (letter.toString().length() == 0) {
          if (digit > 0) {
            letter.insert(0, oneDigitToLetter(digit) + HUNDRED);
          }
        } else if (digit > 0) {
            letter.insert(0, oneDigitToLetter(digit) + HUNDRED + "and");
        }
      }

      else if(i == 3) {
        if (letter.toString().length() == 0) {
          letter.insert(0, oneDigitToLetter(digit) + THOUSAND);
        } else {
          letter.insert(0, oneDigitToLetter(digit) + THOUSAND + "and");
        }
      }
    }
    return letter.toString();
  }

  static String oneDigitToLetter(int digit) {
    StringBuilder letter = new StringBuilder();

    switch (digit) {
      case 0:
        letter.insert(0, ZERO);
        break;
      case 1:
        letter.insert(0, ONE);
        break;
      case 2:
        letter.insert(0, TWO);
        break;
      case 3:
        letter.insert(0, THREE);
        break;
      case 4:
        letter.insert(0, FOUR);
        break;
      case 5:
        letter.insert(0, FIVE);
        break;
      case 6:
        letter.insert(0, SIX);
        break;
      case 7:
        letter.insert(0, SEVEN);
        break;
      case 8:
        letter.insert(0, EIGHT);
        break;
      case 9:
        letter.insert(0, NINE);
        break;
    }

    return letter.toString();
  }
}
