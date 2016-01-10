import java.util.*;
import java.io.*;
import java.math.*;
class Solution {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    ArrayList<String> words = new ArrayList<String>();
    try {
      BufferedReader in = new BufferedReader (new FileReader("p042_words.txt"));
      String str = in.readLine();
      str = str.substring(str.indexOf("\""));

      while(str.length() > 3) {
        str = str.substring(1);
        String word = str.substring(0, str.indexOf("\""));
        words.add(word);
        if (str.contains(",")) {
          str = str.substring(str.indexOf(","));
        }
        str = str.substring(str.indexOf("\""));
      }
    } catch (IOException e) {
      System.out.println("file not found");
    }

    int count = 0;
    for (int i = 0; i < words.size(); i++) {
      int[] t = toWordInt(words.get(i).toCharArray());
      int wordSum = 0;
      for (int j = 0; j < t.length; j++) {
        wordSum += t[j];
      }
      if (isTriangle(wordSum)) {
        count++;
      }
    }
    System.out.println(count);
    System.out.println("totalTime: " + (System.currentTimeMillis() - startTime) + " milliseconds");
  }

  static int[] toWordInt(char[] word) {
    int[] wordInt = new int[word.length];
    for (int i = 0; i < word.length; i++) {
      switch (word[i]) {
        case 'A': case 'a': wordInt[i] = 1; break;
        case 'B': case 'b': wordInt[i] = 2; break;
        case 'C': case 'c': wordInt[i] = 3; break;
        case 'D': case 'd': wordInt[i] = 4; break;
        case 'E': case 'e': wordInt[i] = 5; break;
        case 'F': case 'f': wordInt[i] = 6; break;
        case 'G': case 'g': wordInt[i] = 7; break;
        case 'H': case 'h': wordInt[i] = 8; break;
        case 'I': case 'i': wordInt[i] = 9; break;
        case 'J': case 'j': wordInt[i] = 10; break;
        case 'K': case 'k': wordInt[i] = 11; break;
        case 'L': case 'l': wordInt[i] = 12; break;
        case 'M': case 'm': wordInt[i] = 13; break;
        case 'N': case 'n': wordInt[i] = 14; break;
        case 'O': case 'o': wordInt[i] = 15; break;
        case 'P': case 'p': wordInt[i] = 16; break;
        case 'Q': case 'q': wordInt[i] = 17; break;
        case 'R': case 'r': wordInt[i] = 18; break;
        case 'S': case 's': wordInt[i] = 19; break;
        case 'T': case 't': wordInt[i] = 20; break;
        case 'U': case 'u': wordInt[i] = 21; break;
        case 'V': case 'v': wordInt[i] = 22; break;
        case 'W': case 'w': wordInt[i] = 23; break;
        case 'X': case 'x': wordInt[i] = 24; break;
        case 'Y': case 'y': wordInt[i] = 25; break;
        case 'Z': case 'z': wordInt[i] = 26; break;
      }
    }


    return wordInt;
  }

  static boolean isTriangle (int t) {

    int triangle = 0;
    for (int i = 1; triangle <= t; i++) {
      triangle = i * (i + 1) / 2;

      if (t == triangle) {
        return true;
      }
    }

    return false;
  }
}
