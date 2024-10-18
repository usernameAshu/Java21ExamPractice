package interview_prep.dataStructures.leetcode.twoPointers;

import java.util.*;

/**
 * Explaination: https://www.youtube.com/watch?v=DhFh8Kw7ymk
 */
public class ThreeSum {
    public static void main(String[] args) {

//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0};
//        int[] nums = {-5, 0, -2, 3, -2, 1, 1, 3, 0, -5, 3, 3, 0, -1};
        int[] nums = {0,0,0,0};
        List<List<Integer>> answers = new ThreeSum().threeSum(nums);

        answers.stream()
                .forEach(System.out::println);

    }

    /**
     * Given an integer array nums, return all the triplets
     * [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     * <p>
     * Example:
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        int target = 0;
        Arrays.sort(nums);
//        for (int n : nums)
//            System.out.print(n + " ");
        System.out.println();
        int n = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        for (i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if ((i > 0 && nums[i - 1] == nums[i])) {
                    break;
                } else if (sum > target || (k < n - 1 && nums[k] == nums[k + 1])) {
                    k--;
                } else if (sum < target || (j > i + 1 && nums[j - 1] == nums[j])) {
                    j++;
                } else {
                    results.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }

            }
        }

        return results;
    }


    public List<List<Integer>> threeSum_anotherApproach(int[] nums) {
        int target = 0;
        int n = nums.length;
        List<List<Integer>> answers = new ArrayList<>();
        int i = 0, j = 0;
        for (i = 0; i < n - 2; i++) {
            int newTarget = target - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (j = i + 1; j < n; j++) {
                int compliment = newTarget - nums[j];
                if (map.containsKey(compliment)) {
                    int compPos = map.get(compliment);
                    int[] ans = new int[]{nums[i], nums[j], nums[compPos]};
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[compPos]);
                    if (answers.isEmpty()) {
                        answers.add(list);
                    } else {
                        boolean isDuplicate = answers.stream()
                                .anyMatch(list::containsAll);
                        if (!isDuplicate) {
                            answers.add(list);
                        }
                    }
                }
                map.put(nums[j], j);
            }
        }

        return answers;
    }
}
