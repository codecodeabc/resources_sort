package leetcode.swordtooffer;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// Related Topics 字符串
// 👍 139 👎 0
public class ReplaceSpace {
    public String replaceSpace(String s) {


        StringBuffer buffer = new StringBuffer("");
        char[] chars = s.toCharArray();
        char empty = ' ';
        for (char c : chars) {
            if (empty == c) {
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();

        //return s.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        String s = new ReplaceSpace().replaceSpace("We are happy");
        System.out.println(s);
    }
}
