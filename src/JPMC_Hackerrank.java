import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JPMC_Hackerrank {

  public static void main(String[] args) {
    String s = "uaccd";
    String t = "gbbeg";
    int maxCost = 4;
    String anagram = "1234556667855678";
    //String anagram = "2133326615727117001540261141407327120031612260317493998987993857958996993904815918596499598790384428";
//    String anagram = "00024910032170000511706041211032982217540807261218714025201106942331420123012060214301036000241236700001401501330562041201125231022232080160981050907086640132161003308002402441580600440021391352617023463174630521114363140330623253011531202220311277954612537080137064014106250680002830109063261360321101059413315214446150311200643052015254242124400010090218743824202120104351388040420833760200016145002512218052170450211004661240108307301101969861027363449300081084835881202023047917100472104503013352031552219071106341152921103062608713516250093503222704212031841401021521462090250904002051035023203160162120242427300101239975300421003011172305040330225233131101032023212025309047341581104870016728301312702053323004638223057022311434613211222210172260250326232013404420615423020341410221213961013111001306313509701263520001101800731131402203953453732304041203005173280242181600070101231031524404707571436610000119102633172213336081142403313149962231151533502004121115417122501301800000135014070142204589468585807795688592997";
    //System.out.println(sameSubstring(s,t,maxCost));
    System.out.println(getAnagram2(anagram));
  }

  /*
   * Complete the 'getAnagram' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int getAnagram(String s) {
    // Write your code here
    //compare 1st of the string to 2nd half
    //return the number of operations needed to make it an anagram

    //234  123
    int L = s.length();
    String first = s.substring(0, L / 2);
    String second = s.substring(L / 2);
    System.out.println(first+"\n"+ second);
    int index = 0;
    int ops1 = 0;
    int ops2= 0;
    while (index < L / 2) {
      String c1 = Character.toString(first.charAt(index));
      String c2 = Character.toString(second.charAt(index));
      if (!second.contains(c1)) {
        ops1++;
      }
      if(!first.contains(c2)) {
        ops2++;
      }
      index++;
    }

    System.out.println("Operation count: "+ops1+" , "+ ops2);
    return ops1;

  }

  public static int getAnagram2(String s) {
    int L = s.length();
    String first = s.substring(0, L / 2);
    String second = s.substring(L / 2);
    System.out.println(first+"\n"+ second);
  int ops1 = 0;
  int ops2 = 0;
    char[] fChars = first.toCharArray();
    char[] sChars = second.toCharArray();
    Map<Character, Integer> charCountMap1 = new HashMap<>();
    for (char c : fChars) {
      charCountMap1.put(c, charCountMap1.getOrDefault(c, 0) + 1);
    }
    Map<Character, Integer> charCountMap2 = new HashMap<>();
    for (char c : sChars) {
      charCountMap2.put(c, charCountMap2.getOrDefault(c, 0) + 1);
    }

    System.out.println(charCountMap1);
    System.out.println(charCountMap2);

    for(Map.Entry<Character, Integer> entry: charCountMap1.entrySet()) {
        Character key = entry.getKey();
        int val1 = entry.getValue();
        Integer val2 = charCountMap2.get(key);
        if(val2 != null) {
          ops1 += Math.abs(val1 - val2);
        } else {
          ops1 += val1;
        }
    }
    System.out.println("First half ops: "+ ops1);
    //second half ops
    for(Map.Entry<Character, Integer> entry: charCountMap2.entrySet()) {
      Character key = entry.getKey();
      int val1 = entry.getValue();
      Integer val2 = charCountMap1.get(key);
      if(val2 != null) {
        ops2 += Math.abs(val1 - val2);
      } else {
        ops2 += val1;
      }
    }
    System.out.println("Second half ops: "+ ops2);

    return Math.min(ops1, ops2);
  }

  /*
   * Complete the 'sameSubstring' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. STRING t
   *  3. INTEGER K
   */

  public static int sameSubstring(String s, String t, int K) {
    // Write your code here
    int currMax = 0;
    int prevMax = 0;
    int L1 = s.length();
    int L2 = t.length();
    int index = 0;
    while (index < L1 && index < L2) {
      int cost = Math.abs(s.charAt(index) - t.charAt(index));
      if (cost <= K) {
        currMax++;
      } else {
        if (prevMax < currMax) {
          prevMax = currMax;
        }
        currMax = 0;
      }
      index++;
    }
    if (prevMax < currMax) {
      prevMax = currMax;
    }
    return prevMax;
  }

}
