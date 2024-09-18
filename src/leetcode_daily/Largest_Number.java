package leetcode_daily;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class Largest_Number {

    public static void main(String[] args) {
//        int[] nums = {3,30,34,5,9};
        int[] nums = {999999991,9};
        String maxInteger = new Largest_Number().largestNumber(nums);

        System.out.println(maxInteger);

    }

    /**
     * Greedy approach
     * Sorting is done
     *
     * Approach 1:
     * Bubble sort the array, and compare 2 spots at a time,
     * which ever combination is greater, the beginning number and ending number should swap postions
     *
     * at the end the array will be arranged in the order such as concatinating the array to string will
     * produce the maximum number from the combination
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        // Sort the array based on custom comparator
        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.reducing("", (a, b) -> a + b));

        // Handle the case where the largest number is "0"
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }

    public String largestNumber_2(int[] nums) {
        int L = nums.length;
        for(int i=0; i<L-1; i++) {

            for(int j = i+1; j<L; j++) {
                int num1 = nums[i];
                int num2 = nums[j];

                String combStr = String.valueOf(num1)+String.valueOf(num2);
                int comb1 = Integer.parseInt(combStr);
                String combStr2 = String.valueOf(num2)+String.valueOf(num1);
                int comb2 = Integer.parseInt(combStr2);

                if(comb1 < comb2) {
                    //swap the elements
                    nums[i] = nums[i] + nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];
                }
            }
        }

        //concat the newly arranged array elements
        return Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .reduce("", (s1, s2) -> s1 + s2);
    }
}
