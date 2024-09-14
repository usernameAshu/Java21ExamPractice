package interview_prep.dataStructures.leetcode.array;

/**
 * Rotate the array K places to right (LeetCode 189)
 */
public class RotateArray {

    public static void main(String[] args) {

        new RotateArray().rotate(new int[]{1,2}, 3);

    }


    public void rotate(int[] nums, int k) {
        //Original array
        for (int el : nums)
            System.out.print(el + " ");

        k = k % nums.length;
        //reverse the array
        int left = 0;
        int right = nums.length - 1;
        reverse(nums, left, right);


        System.out.println("\n------------");
        //list is now reversed
        //now we need to reverse both chunks,
        //chunk 1: first k elements
        //chunk 2: remaining el

        //chunk 1
        left = 0;
        right = k - 1;
        reverse(nums, left, right);

        //chunk 2
        left = k;
        right = nums.length - 1;
        reverse(nums, left, right);

        //final array:
        for (int el : nums)
            System.out.print(el + " ");


    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] = nums[left] + nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
            left++;
            right--;
        }
    }
}
