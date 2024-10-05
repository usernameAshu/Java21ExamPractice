package interview_prep.dataStructures.leetcode.array_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Leet Code: 13. Roman to Integer
 */
class Roman_To_Integer {
    public static void main(String[] args) {
        Roman_To_Integer obj = new Roman_To_Integer();

        int result = obj.romanToInt("MCMXCIV");
        System.out.println(result);
    }
    public int romanToInt(String s) {
        char[] crr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] arr = s.toCharArray();

        int lastIndex = arr.length-1;
        char lastElement = s.charAt(lastIndex);
        int sum = map.get(lastElement);
        if(s.length() ==1) return sum;

        for(int i = lastIndex-1; i>=0; i--) {
            if(map.get(arr[i+1]) > map.get(arr[i])) {
                //substraction case
                sum = sum - map.get(arr[i+1]) + ( map.get(arr[i+1]) - map.get(arr[i]));

            } else {
                sum += map.get(arr[i]);
            }
        }

        return sum;
    }


}