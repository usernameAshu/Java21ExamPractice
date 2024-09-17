package interview_prep.dataStructures.leetcode.array_strings;

import java.util.LinkedList;

public class First_Unique_Character {

    public static void main(String[] args) {
        int position = new First_Unique_Character().firstUniqChar("aabb");

        System.out.println("\nIndex Position: " + position);
    }

    /**
     * Given a string s, find the first non-repeating character in it
     * and return its index. If it does not exist, return -1.
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {

        char[] carr = new char[1];
        int k = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int afterPos = -1;
            int beforePos = -1;
            if (i != s.length() - 1) {
                afterPos = s.indexOf(c, i + 1);
            }
            if (i != 0) {
                beforePos = s.indexOf(c, 0, i);
            }
            if (afterPos == -1 && beforePos == -1) {
                //unique character
                carr[k] = c;
                break;
            }
            i++;
        }


        for (char c : carr)
            System.out.print(c + " ");
        char c = carr[0];
        if (c >= 97 && c <= 122) {
            return s.indexOf(c);
        }
        return -1;
    }


    public int firstUniqChar_2(String s) {
        //leetcode
        s = s.toLowerCase();
        boolean[] bool = new boolean[26];
        LinkedList<Character> list = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (list.contains(c)) {
                list.remove((Character) c);
            } else {
                int index = (int) c - 97;
                if (!bool[index]) {
                    list.add(c);
                    bool[index] = true;
                }
            }
            i++;
        }

        System.out.println(list);
        if (!list.isEmpty()) {
            return s.indexOf((char) list.get(0));
        }
        return -1;
    }
}
