package interview_prep.dataStructures.leetcode.array;

public class Remove_Element {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int c = new Remove_Element().removeElement(nums, val);
        for(int n: nums)
            System.out.print(n+ " ");
        System.out.println("\nValue:"+c);
    }

    /**
     * LeetCode 27
     * Example 2:
     *
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,4,0,3,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
     * Note that the five elements can be returned in any order.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int j=0;

        //Input: nums = [0,1,2,2,3,0,4,2], val = 2
        for(int i= 0; i< len; i++ ) {
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

}
