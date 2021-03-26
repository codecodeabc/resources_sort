package leetcode.twopointer;


/**
 * 167. Two Sum II - Input array is sorted (Easy)
 * 题目描述
 * 在一个增序的整数数组里找到两个数，使它们的和为给定值。已知有且只有一对解。
 * 输入输出样例
 * 输入是一个数组（numbers）和一个给定值（target）。输出是两个数的位置，从 1 开始计数。
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * 在这个样例中，第一个数字（2）和第二个数字（7）的和等于给定值（9）
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers,int target){
        int i = 0;
        int j = numbers.length-1;
        while (i < j){
            if(numbers[i]+numbers[j] < target){
                i++;
            }else if(numbers[i]+numbers[j] > target){
                j--;
            }else{
                break;
            }
        }
        return new int[]{i,j};
    }
}
