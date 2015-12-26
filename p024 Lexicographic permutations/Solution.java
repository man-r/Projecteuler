import java.util.*;
import 	java.math.BigInteger;

class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int lexiCount = 0;

    for (int a = 0; a < 10 && lexiCount < 1000000; a++) {
      for (int b = 0; b < 10; b++) {
        for (int c = 0; c < 10; c++) {
          for (int d = 0; d < 10; d++) {
            for (int e = 0; e < 10; e++) {
              for (int f = 0; f < 10; f++) {
                for (int g = 0; g < 10; g++) {
                  for (int h = 0; h < 10; h++) {
                    for (int i = 0; i < 10; i++) {
                      for (int j = 0; j < 10; j++) {
                        if (a != b && a != c && a != d && a != e && a != f && a != g && a != h && a != i && a != j) {
                          if (b != c && b != d && b != e && b != f && b != g && b != h && b != i && b != j) {
                            if (c != d && c != e && c != f && c != g && c != h && c != i && c != j) {
                              if (d != e && d != f && d != g && d != h && d != i && d != j) {
                                if (e != f && e != g && e != h && e != i && e != j) {
                                  if (f != g && f != h && f != i && f != j) {
                                    if (g != h && g != i && g != j) {
                                      if (h != i && h != j) {
                                        if (i != j) {
                                          lexiCount++;
                                          //System.out.println(a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g + "" + h + "" + i);
                                          if (lexiCount == 1000000) {
                                            System.out.println(a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g + "" + h + "" +  i + "" + j);
                                            break;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println("lexiCount: " + lexiCount );
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }
}
