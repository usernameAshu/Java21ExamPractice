package interview_prep.DSA_Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Complement method
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] ar = {0,2,3,4,9,8};
        int target = 7;
        int[] ans = new TwoSum().findArrayIndices(ar, target);
        Arrays.stream(ans).forEach(e -> System.out.print(e+ " "));

    }

    //[0,2,3,4,9,8] sum-> 7 => [2,3]
    int[] findArrayIndices(int[] arr, int target) {
        Map<Integer,Integer> compMap = new HashMap<>();
        for(int i=0; i< arr.length; i++) {
            int compliment = target-arr[i];
            if(compMap.containsKey(compliment)) {
                return new int[]{i, compMap.get(compliment)};
            }
            compMap.put(arr[i], i);
        }

        return null;
    }
}
