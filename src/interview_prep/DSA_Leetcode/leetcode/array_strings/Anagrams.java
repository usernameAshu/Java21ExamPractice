package interview_prep.DSA_Leetcode.leetcode.array_strings;

public class Anagrams {

    public static void main(String[] args) {
        String s = "aacc", t = "ccac";
        boolean isAnagram = new Anagrams().isAnagram(s, t);
        System.out.println("Is Anagram ? "+ isAnagram);
    }

    /**
     * Given two strings s and t, return true if t is an
     * anagram
     * of s, and false otherwise.
     * Both strings are of lowercase
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     *
     * Output: false
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        /**
         * We are creating a int array, which will contain the frequency of each character in 1st string
         * For 2nd string , we will reduce the frequency for that character
         * If the entire frequency array is 0 then , words are anagramsS
         */
        int[] freqChar = new int[26];

        char[] sChar = s.toCharArray();

        for (char c : sChar) {
            int index = c - 97;
            freqChar[index]++;
        }

        char[] tChar = t.toCharArray();
        for (char c : tChar) {
            int index = c - 97;
            freqChar[index]--;
        }

        for(int c: freqChar) {
            if(c != 0) {
                return false;
            }
        }

        return true;
    }
}

/**
 * aacc
 *
 * ccac
 * [1,..1]
 * [
 */