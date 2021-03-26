package leetcode.twopointer;

/**
 * 88 归并两个有序数组
 * 题目描述
 * 给定两个有序数组，把两个数组合并为一个。
 * 输入输出样例
 * 输入是两个数组和它们分别的长度 m 和 n。其中第一个数组的长度被延长至 m + n，多出的
 * n 位被 0 填补。题目要求把第二个数组归并到第一个数组上，不需要开辟额外空间。
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: nums1 = [1,2,2,3,5,6]
 */
public class MergeSortArray {

    public static int[] mergeSortArray(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        for (; i < nums1.length && j < nums2.length; i++) {
            if(nums1[i] == 0){
                nums1[i] = nums2[j];
                j++;
                continue;
            }else if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        mergeSortArray(nums1,nums2);
    }

}
