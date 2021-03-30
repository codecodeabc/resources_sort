package leetcode.twopointer;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class ValidPalintrome2 {
    public boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length-1;
        while(i <= j){
            //出现不是相等的位置
            if(array[i] != array[j]){
                //选择去掉i或j 字符，判断剩余子字符串是不是回文，有一个情况是回文则符合要求
                return validPalindromeOne(s.substring(i+1,j+1)) || validPalindromeOne(s.substring(i,j));
            }else{
                i++;
                j--;
                continue;
            }
        }
        return true;
    }

    private boolean validPalindromeOne(String substring) {
        char[] array = substring.toCharArray();
        int i = 0;
        int j = array.length-1;
        while(i <= j){
            if(array[i] != array[j]) {
                return false;
            }else{
                i++;
                j--;
                continue;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalintrome2 valid = new ValidPalintrome2();
        boolean aba = valid.validPalindrome("abaaac");
        System.out.println(aba);
    }
}
