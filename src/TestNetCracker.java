import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestNetCracker {

  static List<List<String>> getAnagrams(String... str) {

    //create a bit arary for the alphabets
    //which bit flopped , that should match with the string, -> anagrams
    //problem: creating too much bit arrays
    boolean[] bits = new boolean[26];
    List<String> anagram = new ArrayList<>();
    List<List<String>> anagrams = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    Comparator<Character> charAsc = (c1, c2) -> c1.compareTo(c2);
    for (String s : str) {
      //sort the string
      List<Character> chars = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
        chars.add(s.charAt(i));
      }
      chars.sort(charAsc);
      String sortedStr =
          chars.stream()
              .reduce(new StringBuilder(), (sb, c) -> sb.append(c), (sb1, sb2) -> sb1.append(sb2))
              .toString();

      List<String> ans = map.get(sortedStr);
      if (ans != null) {
        ans.add(s);
        map.put(sortedStr, ans);
      } else {
        List<String> ans2 = new ArrayList<>();
        ans2.add(s);
        map.put(sortedStr, ans2);
      }
    }

    map.keySet()
        .forEach(key -> anagrams.add(map.get(key)));

    return anagrams;
  }

  void main() {

    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> anagrams = getAnagrams(strs);
    System.out.println(anagrams);

  }
}


