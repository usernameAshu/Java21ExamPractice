package interview_prep.DSA_Leetcode.leetcode.array_strings;

/**
 * LC 80
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
 * such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Remove_Duplicates_Sorted_Array_II {

    /**
     * Video reference: https://www.youtube.com/watch?v=Jg4zXJAH_Kg
     *
     * Approach:
     * We are using 2 pointer with i & j starting from index 1, and counter as 1
     * Iterate the loop from i to L-1
     * Check i with (i-1) position
     *  if both have same value increase the counter
     *  else set counter to 1
     *
     *  if counter is <= 2 , then set the j index with i index value, and increase j index
     * End loop
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int L = nums.length;
        int i = 1, j = 1, c = 1;
        while (i < L) {

            if (nums[i] == nums[i - 1]) {
                c++;
            } else {
                c = 1;
            }


            if (c <= 2) {
                nums[j] = nums[i];
                j++;
            }

            i++;

        }

        return j;
    }
}
