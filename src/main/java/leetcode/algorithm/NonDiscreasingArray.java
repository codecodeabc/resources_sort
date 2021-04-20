package leetcode.algorithm;


import com.sun.javaws.IconUtil;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class NonDiscreasingArray {
    public static boolean checkPossibility(int[] nums) {
        /*int sum = 0;
        int len = 0;
        for(int i = 0;i<nums.length;i++){
            if(i+1<nums.length && nums[i] > nums [i+1]){
                len++;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(i-1 >=0 && i+1<nums.length){
                if((nums[i-1]< nums[i] && nums[i] > nums[i+1])||(nums[i-1] > nums[i] && nums[i] < nums[i+1])){
                    sum++;
                }
            }
        }
        if(len == nums.length-1){
            return false;
        }else{
            return  sum <= 1;
        }*/
        /**
         *   int n = nums.length, cnt = 0;
         *         for (int i = 0; i < n - 1; ++i) {
         *             int x = nums[i], y = nums[i + 1];
         *             if (x > y) {
         *                 cnt++;
         *                 if (cnt > 1) {
         *                     return false;
         *                 }
         *                 if (i > 0 && y < nums[i - 1]) {
         *                     nums[i + 1] = x;
         *                 }
         *             }
         *         }
         *         return true;
         *
         */
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            //获取下表为 i 和 i+1 的值
            int x = nums[i], y = nums[i + 1];
            //当 出现不是非递减的情况，记录到cnt
            if (x > y) {
                cnt++;
                //超过次数限制则false
                if (cnt > 1) {
                    return false;
                }
                //当 i+1的值 在   nums[i-1]  < y <  x 这个范围里，则可以修改该值，
                // 比如 4  4   3  3 这种情况 4 4 和 3 3基本就是分成两段，无法通过修改一个值来形成非递减
                // 通过赋值 跳到上一步判断 if(cnt>1) 来返回 false
                // 类似 -1 4 2 这种只是 4 单个影响非递减序列，记录为1即可
                // 2 1 3 这种也是单个值影响
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[]nums = {-1,4,2,3};
        System.out.println(checkPossibility(nums));;
    }
}
