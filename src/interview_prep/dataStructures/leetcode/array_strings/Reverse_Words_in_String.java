package interview_prep.dataStructures.leetcode.array_strings;

public class Reverse_Words_in_String {

    public static void main(String[] args) {
        String result = new Reverse_Words_in_String().reverseWords("a good   example");
        System.out.println(result);
    }

    public String reverseWords(String s) {
        StringBuilder sbr = new StringBuilder(s.trim().length());

        String str = s.trim();
        int n = str.length() - 1;
        int j = n, k = n;
        while (n > -1) {
            if (str.charAt(n) != 32) {
                j--;
                n--;
            } else if (str.charAt(n) == 32) {
                if (str.charAt(n + 1) != 32) {
                    sbr.append(str.substring(j + 1, k + 1)).append(" ");
                }
                j--;
                k = j;
                n--;
            }
        }
        //last word
        sbr.append(str.substring(n+1, k+1));

        return sbr.toString();
    }
}
