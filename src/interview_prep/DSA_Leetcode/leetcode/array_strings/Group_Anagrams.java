package interview_prep.DSA_Leetcode.leetcode.array_strings;

import java.util.*;

/**
 * Given an array of strings strs, group the
 * anagrams
 *  together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 */
public class Group_Anagrams {

    void main(String[] args) {

        List<List<String>> result = groupAnagrams(new String[]{"zoo","ozo", "eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println(result);

    }

    /**
     * Approaching this problem using a frequency map
     * map will have the freq-string as key and set of strings which make that freq-string as value
     * Key=1a1b1t : Value=[bat]
     * Key=1a1e1t : Value=[eat, tea, ate]
     * Key=1a1n1t : Value=[tan, nat]
     *
     * So, bat has 1a , 1b and 1t
     * eat, tea, ate has 1a, 1e,1t each
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqMap = new HashMap<>();

        for (String str : strs) {
            String val = generateFrequencyString(str);
            if (freqMap.containsKey(val)) {
                List<String> strings = freqMap.get(val);
                strings.add(str);
                freqMap.put(val, strings);
            } else {
                freqMap.put(val, new ArrayList<>(Arrays.asList(str)));
            }
        }

        freqMap.forEach((k,v) -> System.out.println("Key=" +k+ " : Value="+v));

        List<List<String>> result = new ArrayList<>();

        freqMap.forEach((k, v) -> {
            result.add(v);
        });

        return result;
    }

    private static String generateFrequencyString(String str) {
        int[] freq = new int[26];
        char[] ch = str.toCharArray();
        int i = 0;
        for(char c: ch) {
            int index = c - 97;
            freq[index]++;
        }

        StringBuilder sbr = new StringBuilder();
        for(int index =0; index < freq.length; index ++) {
            int intVal = freq[index];

            if(freq[index]!=0) {
                char c = (char)(index + 97);
                sbr.append(intVal);
                sbr.append(c);
            }
        }

        return sbr.toString();
    }
}
