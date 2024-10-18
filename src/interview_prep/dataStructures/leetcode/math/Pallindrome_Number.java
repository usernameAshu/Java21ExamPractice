package interview_prep.dataStructures.leetcode.math;

public class Pallindrome_Number {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int j = 0;
        int k = s.length() -1;

        while(j < k) {
            if(s.charAt(j) != s.charAt(k)) {
                return false;
            }
            j++;
            k--;
        }
        return true;
    }
}
