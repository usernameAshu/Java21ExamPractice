package interview_prep.dataStructures.leetcode.array_strings;

import java.util.Arrays;

public class Merge_Sorted_Array {

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        int m = 3;
//        int n = 3;
        //--------------//
//        int[] nums1 = {2,0};
//        int[] nums2 = {1};
//        int m = 1;
//        int n = 1;
        //--------------//
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {1,2,3,4,5};
        int m = 0;
        int n = 5;

        Merge_Sorted_Array obj = new Merge_Sorted_Array();

        obj.merge(nums1, m, nums2, n);

        Arrays.stream(nums1).forEach(System.out::print);
    }

    /**
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * <p>
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
     * that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * <p>
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * <p>
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * <p>
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totLength = m + n;
        if (nums1.length == (m + n) && nums2.length == n && (m >= 0 && m <= 200) && (totLength >= 1 && totLength <= 200)) {
            //place the solution here
            if (m == 0) {
                int i = 0;
                while(i < nums2.length) {
                    nums1[i] = nums2[i];
                    i++;
                }
            } else {
                //m > 0 & n > 0
                int[] nums3 = new int[m];
                int i = 0;
                while(i < m) {
                    nums3[i] = nums1[i];
                    i++;
                }
                //nums3 = [1,2,3] , nums2 = [2,5,6]
                mergesort(nums3 , nums2, nums1);
            }
        }

    }

    private void mergesort(int[] nums3, int[] nums2, int[] nums1) {
        int i =0,j = 0,k = 0;

        while( i < nums3.length && j < nums2.length) {
            if(nums3[i] < nums2[j]) {
                nums1[k] = nums3[i];
                i++;
                k++;
            } else if( nums2[j] < nums3[i]) {
                nums1[k] = nums2[j];
                j++;
                k++;
            } else {
                nums1[k] = nums3[i];
                nums1[++k] = nums2[j];
                i++;
                j++;
                k++;
            }
        }

        //remaining elements
        while(i < nums3.length) {
            nums1[k] = nums3[i];
            i++;
            k++;
        }

        while(j < nums2.length) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}
