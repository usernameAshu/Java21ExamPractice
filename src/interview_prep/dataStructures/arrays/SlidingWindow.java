package interview_prep.dataStructures.arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        //array of 10 integers
        int[] arr = {100, 200, 12, 678, 10, 500, 56};
        int k = 2;

        //Find maximum sum of k sub-array from 'arr' array
        int maxSum = new SlidingWindow().findMaxSum(arr, k);
        System.out.println(maxSum);
    }

    int findMaxSum(int[] arr, int k) {
        int length = arr.length;
        if (length < k) {
            return -1;
        }
        //pre sum
        int sum = 0;
        int maxSum = 0;
        int i = 0;
        //if array is itself of k elements
        while (i < k) {
            sum = sum + arr[i];
            i++;
        }
        maxSum = sum;
        if (length == k) {
            return sum;
        }
//        1, 2, 3, 4, 5, 6, 7
//        0, 1, 2, 3, 4, 5, 6

        for (i = 1; i < length - k + 1; i++) {
            sum = sum - arr[i - 1] + arr[i - 1 + k];
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
}
