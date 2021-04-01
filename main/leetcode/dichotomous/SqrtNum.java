package leetcode.dichotomous;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class SqrtNum {
    public int mySqrt(int x) {

        int l = 0;
        int r = x;
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                //ans用于记录上一次循环的中间值就是平方根的整数值
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SqrtNum sqrtNum = new SqrtNum();
        System.out.println(sqrtNum.mySqrt(10));
    }
}



























