package leetcode_daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A sentence is a string of single-space separated words where each word consists only of lowercase letters.
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
 * <p>
 * Output: ["sweet","sour"]
 * <p>
 * Explanation:
 * <p>
 * The word "sweet" appears only in s1, while the word "sour" appears only in s2.
 * <p>
 * Example 2:
 * <p>
 * Input: s1 = "apple apple", s2 = "banana"
 * <p>
 * Output: ["banana"]
 */
public class Uncommon_Words {

    public static void main(String[] args) {
//        String s1 = "this apple is sweet", s2 = "this apple is sour";
        String s1 = "fd kss fd", s2 = "fd fd kss";
        String[] strings = new Uncommon_Words().uncommonFromSentences(s1, s2);
        System.out.println();
        for(String str: strings)
            System.out.print(str+ " ");
    }

    public String[] uncommonFromSentences(String s1, String s2) {

        Map<String, Integer> countMap = new ConcurrentHashMap<>();

        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        List<String[]> list = Arrays.asList(arr1, arr2);

        for(String[] arr: list) {
            int i = 0;
            while(i < arr.length) {
                String key = arr[i];
                if(countMap.containsKey(key)) {
                    countMap.put(key, countMap.get(key)+ 1);
                } else {
                    countMap.put(key, 1);
                }
                i++;
            }
        }

        //print the map
//        countMap.forEach((key, value) -> System.out.println(key + " " + value));

       StringBuilder result = new StringBuilder();
        int k = 0;
        for(Map.Entry<String, Integer> set : countMap.entrySet()) {
            if(set.getValue() == 1) {
                result.append(set.getKey()+" ");
            }
        }

        String res = result.toString();
        if(res.isBlank()) {
            return new String[]{};
        } else {
            return res.split(" ");
        }

    }
}
