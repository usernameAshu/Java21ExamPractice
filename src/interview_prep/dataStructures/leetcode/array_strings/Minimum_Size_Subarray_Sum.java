package interview_prep.dataStructures.leetcode.array_strings;

/**
 * LC 209
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a <b>subarray</b>
 * whose <b>sum is greater than or equal to target</b>. If there is no such subarray, return 0 instead.
 * <p>
 * <br>Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * <br>Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <br>Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class Minimum_Size_Subarray_Sum {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1};
        int target = 11;
        long startTime = System.currentTimeMillis();
        int size = new Minimum_Size_Subarray_Sum().minSubArrayLen_Soln2(target, arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Minimum sibarray size:" + size);

        // Convert to seconds and milliseconds
        long timeDifference = endTime - startTime;
        long seconds = timeDifference / 1000;
        long milliseconds = timeDifference % 1000;

        System.out.println("Time Taken: " + seconds + " seconds and " + milliseconds + " milliseconds");
    }

    /**
     * We need to use a combination of sliding window and two pointers approach
     * pointers - currentSum, minWindow
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0, e = -1, currentSum = 0;
        int length = nums.length;
        int minWindow = length + 1;

        while (e < length) {

            if (currentSum < target) {
                e++;
                if (e >= length)
                    break;
                currentSum += nums[e];

            } else {
                int winSize = e - s + 1;
                minWindow = winSize < minWindow ? winSize : minWindow;
                currentSum -= nums[s];
                s++;
            }

        }

        return minWindow == length + 1 ? 0 : minWindow;
    }


    public int minSubArrayLen_Soln2(int target, int[] nums) {
        int s = 0, e = 0, currentSum = 0;
        int length = nums.length;
        int minWindow = length + 1;

        while (e < length) {
            currentSum += nums[e];
            e++;

            while (currentSum >= target) {
                int winSize = e - s;
                minWindow = Math.min(winSize, minWindow);
                currentSum -= nums[s];
                s++;
            }
        }
        return minWindow == length + 1 ? 0 : minWindow;
    }
}
