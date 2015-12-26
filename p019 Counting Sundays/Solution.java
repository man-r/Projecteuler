import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    ArrayList<Integer> days = new ArrayList<Integer>();

    int day = 1;
    int month = 1;
    int year = 1900;

    int sundayCount = 0;
    while (year < 2001) {
      day = nextMonth(day, month, year);
      month++;
      if (month == 13) {
        month = 1;
        year++;
      }
      if (year > 1900) {
        days.add(day);
      }

    }

    for (int i = 0; i <= day; i+=7) {
      if (days.contains(i)) {
        sundayCount++;
      }
    }

    System.out.println("sundayCount: " + sundayCount);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }


  static int nextMonth(int day, int month, int year) {
    switch (month) {
      case 2:
        day += 28;
        if (isLeap(year)) {
          day += 1;
        }
        break;
      case 4:
        day += 30;
        break;
      case 6:
        day += 30;
        break;

      case 9:
        day += 30;
        break;
      case 11:
        day += 30;
        break;
      default:
        day += 31;
        break;
    }

    return day;
  }

  static boolean isLeap(int year) {
    if (year % 400 == 0) {
      return true;
    } else if (year % 4 == 0 && year % 100 != 0) {
      return true;
    } else {
      return false;
    }
  }
}
