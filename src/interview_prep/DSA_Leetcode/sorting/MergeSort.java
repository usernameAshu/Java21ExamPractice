package interview_prep.DSA_Leetcode.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 1, 8, 9, 3};
        new MergeSort().mergeSort(nums, 0, nums.length - 1);

        for (int el : nums)
            System.out.print(el + " ");
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    void mergeSort(int[] nums, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, h);
            merge(nums, l, mid, h);
        }

    }

    void merge(int[] nums, int l, int mid, int r) {
        int size1 = mid - l + 1;
        int size2 = r - mid;
        int[] left = new int[size1];
        int[] right = new int[size2];

        //load the data into left and right arrays
        for (int i = 0; i < size1; i++)
            left[i] = nums[i + l];
        for (int i = 0; i < size2; i++)
            right[i] = nums[i + mid + 1];

        int i = l, j = 0, k = 0;
        while (j < left.length && k < right.length) {
            if (left[j] <= right[k]) {
                nums[i] = left[j];
                j++;
            } else {
                nums[i] = right[k];
                k++;
            }
            i++;
        }

        //remaining elements
        while (j < left.length) {
            nums[i] = left[j];
            j++;
            i++;
        }

        while (k < right.length) {
            nums[i] = right[k];
            k++;
            i++;
        }
    }

}
