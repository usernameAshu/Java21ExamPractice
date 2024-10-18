package interview_prep.DSA_Leetcode.leetcode.array_strings;

/**
 * You are given an integer array nums.
 * We need to check whether we can jump from 1st index to last index.
 *
 * Jump condition: whatever value is at any index, that's the maximum jump it can take
 * Example: [2,3,1,1,4]
 * Index 0 has 2 , which means we can make 1 or 2 jumps from index 0
 * Index 1 has 3, so we can make 1 or 2 or 3 jumps from index 1
 * So on..
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 */
public class Jump_Game {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        boolean result = new Jump_Game().canJump(nums);
        System.out.println(result);

    }

    /**
     * We took a greedy approach here:
     * Video: https://youtu.be/Gtugy3mRV-A?si=85BEnu_B_vFP1o-M
     *
     * We start from second last position(greedy pos) and check whether we can reach the last pos (Final Pos)
     * If true then we make second last as Final Pos and decrement the Greedy Pos
     * If false, we only decrement the greedy pos.
     *
     * So, we go on checking if greedy pos can reach Final Pos or not, untill greed pos reaches crosses 0 index.
     * If at the end Final Pos reaches 0 index then it's a Valid jump scenario, else return false.
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        //edge cases
        if(nums == null) return false;
        if(nums.length == 1) {
            if(nums[0] == 1 || nums[0]== 0) return true;
            return false;
        }
        int L = nums.length;
        int finalPos = L - 1;
        int greedyPos = L - 2;

        while(greedyPos >= 0) {
            if((greedyPos + nums[greedyPos]) >= finalPos) {
                finalPos = greedyPos;
            }
            greedyPos--;
        }

        return finalPos == 0 ;

    }
}
