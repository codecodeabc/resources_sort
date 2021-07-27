package leetcode.swordtooffer;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104
//
//
//
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
// Related Topics 递归 数学
// 👍 180 👎 0
public class MyPow {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                return myPow(x, Integer.MAX_VALUE) * x;
            } else {
                return myPow(x, -n);
            }
        }
        double half = myPow(x, n >> 1);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        System.out.print(String.format("%.20f", myPow(2f, -20)));
    }
}
