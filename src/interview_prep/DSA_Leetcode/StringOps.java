package interview_prep.DSA_Leetcode;

public class StringOps {
    public static void main(String[] args) {
        new StringOps().test();
    }

    void test() {
        String str = "ashutosh mohanty";
        char[] sc = str.toCharArray();
        String rev = reverse(sc);
        boolean isPallindrom = checkPallindrome("Dad");
        System.out.println(isPallindrom);
    }

    boolean checkPallindrome(String str) {
        int start = 0;
        int last = str.length()-1;
        str = str.toLowerCase();
        char[] sc = str.toCharArray();

        while(last > start) {
            if(sc[last] != sc[start]) {
                return false;
            }
            last--;
            start++;
        }

        return true;
    }

    String reverse(char[] sc) {
        int start = 0;
        int end = sc.length -1;
        while(end > start) {
            char temp = sc[end];
            sc[end] = sc[start];
            sc[start] = temp;
            start++;
            end--;
        }
        start = 0;
        StringBuilder sb = new StringBuilder(sc.length);
        while(start < sc.length) {
            sb.append(sc[start]);
            start++;
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
