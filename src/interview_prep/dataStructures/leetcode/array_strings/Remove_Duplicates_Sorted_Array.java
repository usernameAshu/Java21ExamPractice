package interview_prep.dataStructures.leetcode.array_strings;

/**
 * LC 26
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * <p>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the
 * first k elements of nums contain the unique elements
 * in the order they were present in nums initially.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Remove_Duplicates_Sorted_Array {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {1,1,2};
        int[] nums = {1};
        int k = new Remove_Duplicates_Sorted_Array().removeDuplicates(nums);
        for (int i : nums)
            System.out.print(i + " ");

        System.out.println();
        System.out.println(k);
    }

    public int removeDuplicates(int[] nums) {
        int L = nums.length;
        if (L == 0) return 0;
        if (L == 1) return 1;
        int i = 0, j = 1;

        //[0,0,1,1,1,2,2,3,3,4]
        // i  j
        // c = 1
        // nums[++i] = nums[j] , c--
        //   i j
        // 0,1,2,3,4,2,3,3,4
        while (j < L) {
            while (j < L && (nums[i] == nums[j] || nums[i] > nums[j])) {
                j++;
            }
            if (j < L) nums[++i] = nums[j];
        }
        return i + 1;
    }
}
