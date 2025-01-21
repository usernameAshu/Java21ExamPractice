import java.util.Arrays;

/**
 * LC 238 Product of Array Except Self
 * <p>
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 * <p>
 * [Restriction: cannot use division method, algo should have time complexity: O(n)]
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class _lc_238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        productExceptSelf(nums);
    }

    /**
     * Solution:
     *
     * We create an output array,
     * In that array we store the prefix multiplications : multiplying the values before that index
     * example: input array: [1, 2, 3, 4, 5]
     * initial o/p array: [1, 1, 2, 6, 24]
     *
     * Now, we will traverse this output array backwards, leaving the last index
     * Also, we will store the suffix product from the original input array
     * Suffix product: multiplying the positions after the index.
     * So, now the index value will be the present-value * suffix-value
     * Only exception is index=0, where index-value will be suffix-value
     *
     * new o/p array: [120, 60, 40, 30, 24]
     */
    static int[] productExceptSelf(int[] nums) {
        //[1 , 2, 6, 24]
        //[24,
        int L = nums.length;
        int[] output = new int[L];
        int i = 0;
        int prefix = 1;
        int suffix = 1;

        //create the output array as product of prefix nums
        while (i < L) {
            if (i < 1) {
                output[i] = nums[i];
                i++;
                continue;
            }
            prefix *= nums[i - 1];
            output[i] = prefix;
            i++;
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(output));
        i -= 2;
        //now comparing nums and output array we need to form the result array in-place
        while (i > -1) {
            suffix *= nums[i + 1];
            if (i != 0) output[i] *= suffix;
            else output[i] = suffix;
            i--;
        }

        System.out.println("Result:\n" + Arrays.toString(output));
        return output;
    }
}
