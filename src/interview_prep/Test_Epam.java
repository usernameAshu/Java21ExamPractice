package interview_prep;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test_Epam {

    void main() {

        /*
        You are given a list of lists containing integers. Create a stream to flatten the nested lists,
        remove duplicate integers, and then find the square root of each distinct value.
         */
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> result =

                nestedLists.stream()
                        .flatMap(list -> list.stream())
                        .distinct()
                        .map(i -> (int) Math.sqrt(i))
                        .collect(Collectors.toUnmodifiableList());

        //System.out.println(result);

        /*

        Given a sorted array of distinct integers and a target value, return the index if the target is found.
        If not, return the index where it would be if it were inserted in order.

        You must write an algorithm with O(log n) runtime complexity.

        Example 1:

        Input: nums = [1,3,5,6], target = 5
        Output: 2
         */
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int pos = findIndexPredict(nums, target);
        System.out.println(pos);
    }

    //O(n)
    static int findIndexPredict(int[] nums, int target) {
        //System.out.println(nums.length);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            } else if (target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
        }

        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return -1;
    }

    static int efficeitn() {

        //mid of the array  (recursion)
        //search in the lower half
        //search in the upper

        return 0;
    }

}
