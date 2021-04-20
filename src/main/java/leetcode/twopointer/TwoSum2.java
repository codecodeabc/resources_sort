package leetcode.twopointer;


/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class TwoSum2 {
    public static boolean judgeSquareSum(int c) {
        // a 和 b  的取值为 0 ~ 根号c
        int l = 0 ;
        int r = (int) Math.sqrt(c);
        while(l <= r){
            if(Math.pow(l,2) + Math.pow(r,2) == c ){
                return true;
            }else if(Math.pow(l,2) + Math.pow(r,2) > c){
                r--;
            }else{
                l++;
            }
        }
        return false;
        //费马平方和定理 : 一个非负整数 cc 能够表示为两个整数的平方和，当且仅当 cc 的所有形如 4k+3 的质因子的幂次均为偶数。

        //证明：https://wstein.org/edu/124/lectures/lecture21/lecture21/node2.html
        /**
         *  for (int i = 2; i * i <= c; i++) {
         *             int count = 0;
         *             //判断是质因子
         *             if (c % i == 0) {
         *                 //计算质因子的幂次 记录为count
         *                 while (c % i == 0) {
         *                     count++;
         *                     c /= i;
         *                 }
         *                 //判断 质因子 为 4k+3 的幂次是否是偶数
         *                 if (i % 4 == 3 && count % 2 != 0)
         *                     return false;
         *             }
         * }
         * //c如果是质数，幂次数肯定不是偶数
         *  return c % 4 != 3;
         *
         */
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }

}
