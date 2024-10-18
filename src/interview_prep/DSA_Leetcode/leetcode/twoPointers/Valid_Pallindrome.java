package interview_prep.DSA_Leetcode.leetcode.twoPointers;

import java.util.Locale;

public class Valid_Pallindrome {

    public static void main(String[] args) {
        String test1 = "A: man, a plan, a canal: Panama";
        String test2 = "aa";
        boolean result = new Valid_Pallindrome().isPalindrome(test2);
        System.out.println("\nResult:"+result);
    }


    /**
     * A man, a plan, a canal: Panama
     *
     * to Lowercase
     * A=a
     * ignore space, inc i
     * m=m
     * a=a
     * n=n
     * ignore ,
     * ignore space
     * a==a
     * p==P
     * ignore space, colon
     * l=l
     */

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() -1;
        s = s.toLowerCase(Locale.ENGLISH);
        while(i < j) {
            System.out.print(s.charAt(i));
            if(!isAlphaNumeric(s, i)) {
                i++;
            } else if(!isAlphaNumeric(s,j)) {
                j--;
            } else if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isAlphaNumeric(String s, int i) {
        return (s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57);
    }
}
