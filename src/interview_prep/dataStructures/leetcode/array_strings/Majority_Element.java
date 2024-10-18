package interview_prep.dataStructures.leetcode.array_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 169
 */
public class Majority_Element {

    public static void main(String[] args) {
            int[] nums = {3,2,3};
            new Majority_Element().majorityElement(nums);
    }

    public int majorityElement(int[] nums) {
        int L = nums.length;
        int N = L / 2;

        Map<Integer, Integer> map = new HashMap<>();
        int i =0;
        while(i < L) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                if (++val > N) break;
                map.put(nums[i], val);

            } else {
                map.put(nums[i], 1);
            }
            i++;
        }
        return nums[i];
    }

}
