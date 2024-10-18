package interview_prep.DSA_Leetcode.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] results = new Two_Sum().twoSum(nums, target);

        for (int result : results)
            System.out.print(result + " ");
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> comMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (comMap.containsKey(nums[i]) && comMap.get(nums[i]) != i) {
                return new int[]{comMap.get(nums[i]), i};
            }
            comMap.put(compliment, i);
        }
        return null;
    }
}
