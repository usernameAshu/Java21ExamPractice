package interview_prep.dataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Compliment method
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,9,27};
        int target = 15;
        int[] ans = new ThreeSum().findArrayIndices(ar, target);
        Arrays.stream(ans).forEach(e -> System.out.print(e+ " "));
    }

    //[1,2,3,4,9,12] sum-> 13 => [0,2,4]
    //[1,2,3,4,9,27] sum-> 15 => [1,3,4]
    int[] findArrayIndices(int[] arr, int target) {
        int n = arr.length;
        for(int i=0; i< n-2; i++) {
            int newTarget = target - arr[i];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 1; j < n; j++ ) {
                int compliment = newTarget - arr[j];
                if(map.containsKey(compliment)) {
                    return new int[]{i,j,map.get(compliment)};
                }
                map.put(arr[j], j);
            }
        }

        return null;
    }
}
