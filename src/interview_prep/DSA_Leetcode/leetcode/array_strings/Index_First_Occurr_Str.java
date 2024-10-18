package interview_prep.DSA_Leetcode.leetcode.array_strings;

public class Index_First_Occurr_Str {

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        int result = new Index_First_Occurr_Str().strStr(haystack, needle);
        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1; /*edge case*/

        int i=0;
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        while(i < haystackLength) {

            if(haystack.charAt(i) == needle.charAt(0) && i+needleLength <= haystackLength) {
               if(haystack.substring(i,i+needleLength).equals(needle)) {
                   return i;
               }
            }
            i++;
        }
        return -1;
    }

}
