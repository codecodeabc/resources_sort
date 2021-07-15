package leetcode.swordtooffer;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。
//
// 示例 1：
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//
// 示例 2:
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
// 提示：
//
//
// 2 <= n <= 58
//
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划
// 👍 252 👎 0

public class CutRope {
    /**
     * https://blog.csdn.net/zjx_cfbx/article/details/79951019?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
     *
     *
     *
     * 当N=1时，f(1)=0;
     *
     * 当N=2时，f(2)=1*1=1;
     *
     * 当N=3时，f(3)=max（1*1*1,1*2）=2
     *
     * 当N=4时，f(4)=max（1*1*1*1，1*3，1*2*1, 1*2）=4
     *
     * 我们知道使用动态规划求解问题，需要具备其中一个性质：最优子结构性质，也即我们需要知道状态转移函数。通过对上述状态的描述我们可以进一步简化中间环节：
     *
     * 当N=1时，f(1)=0;
     *
     * 当N=2时，f(2)=1;
     *
     * 当N=3时，f(3)=f(1)*f(2)=2
     *
     * 当N=4时，f(4)=max（f(1)*f(3)，f(2)*f(2)）=4
     *
     * 当N=5时，f(5)=max(f(1)*f(4),f(2)*f(3))=6
     *
     *    .......
     *
     * f(N)=max(f(1)*f(N-1), f(2)*f(N-2) , f(3)*f(N-3) , ... , f(i)*f(N-i) )
     *
     * 由此，我们可以知道状态转移函数为：f(N)= max( f(i) * f(N-i)  ) , 其中i的取值范围为（i>0&&i<=n/2）。

     */
    public static int cuttingRope(int n) {
        // 由于绳子一定要剪一次，所以 0 ~ 3 这个范围的另外计算
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int[] ints = new int[n + 2];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 3;
        for (int i = 4; i <= n; i++) {
            for(int j = 1 ;j <= i/2 ;j++){
                int t = ints[j] * ints[i - j];
                if(t > ints[i]){
                    ints[i] = t;
                }
            }
        }
        return ints[n];
    }

    /**
     * 解法2
     */
    public static int cuttingRope2(int n) {
        // 小于 4 的 都为 n - 1 剪一次
        if (n < 4) return n - 1;
        int res = 1;
        // 大于4 的 尽可能的 剪出 3 来
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        if (n == 4) return res << 2;
        return res * n;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope2(4));
    }
}
