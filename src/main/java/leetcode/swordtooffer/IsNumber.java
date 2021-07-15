package leetcode.swordtooffer;


//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//
// 数值（按顺序）可以分成以下几个部分：
//
//
// 若干空格
// 一个 小数 或者 整数
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数
// 若干空格
//
//
// 小数（按顺序）可以分成以下几个部分：
//
//
// （可选）一个符号字符（'+' 或 '-'）
// 下述格式之一：
//
// 至少一位数字，后面跟着一个点 '.'
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
// 一个点 '.' ，后面跟着至少一位数字
//
//
//
//
// 整数（按顺序）可以分成以下几个部分：
//
//
// （可选）一个符号字符（'+' 或 '-'）
// 至少一位数字
//
//
// 部分数值列举如下：
//
//
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
//
//
// 部分非数值列举如下：
//
//
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
//
//
//
//
// 示例 1：
//
//
//输入：s = "0"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "e"
//输出：false
//
//
// 示例 3：
//
//
//输入：s = "."
//输出：false
//
// 示例 4：
//
//
//输入：s = "    .1  "
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 20
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
//
// Related Topics 字符串
// 👍 213 👎 0

public class IsNumber {
    public static boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        char[] chars = s.trim().toCharArray();
        boolean findNum = false;  // 标记找到数字
        boolean findE = false;    // 标记找到 E / e
        boolean findDot = false;  // 标记找到 小数点
        for (int i = 0, n = chars.length; i < n; ++i) {
            if (chars[i] == '+' || chars[i] == '-') {
                // 不是在正负符号 或 E/e后出现 则 false
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                // 数字就标记找到过数字true
                findNum = true;
            } else if (chars[i] == '.') {
                // 第二次找到 小数点 或 前面找到过E 都为false
                if (findDot || findE) {
                    return false;
                }
                // 标记找到一个小数点
                findDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // e / E 第二次出现或 前面没出现过数字 都为false
                if (findE || !findNum) {
                    return false;
                }
                findE = true;
                findNum = false; // 确保e之后也出现数
            } else {
                return false;
            }
        }
        return findNum;
    }

    public static void main(String[] args) {

    }
}
























