package leetcode.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 */
public class LongestWord {


    public String findLongestWord(String s, List<String> dictionary) {
        //记录匹配最长长度
        int maxlen = 0;
        //记录最长下表
        int index = -1;
        // s字符串指针
        int sIndex = 0;
        // 字典串指针
        int dIndex = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            String s1 = dictionary.get(i);
            int len = 0;
            while(sIndex < s.length() && dIndex < s1.length()){
                if(s.charAt(sIndex) == s1.charAt(dIndex)){
                    sIndex++;
                    dIndex++;
                    len++;
                }else{
                    sIndex++;
                }
            }
            if(dIndex >= s1.length()){
                if(maxlen < len){
                    maxlen = len;
                    index = i;
                }else if(maxlen == len){
                    if(dictionary.get(i).compareTo(dictionary.get(index))<0){
                        maxlen = len;
                        index = i;
                    }
                }
            }
            sIndex = 0;
            dIndex = 0;
        }
        //记录最长index
        return index == -1 ? "":dictionary.get(index);
    }

    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ewaf");
        list.add("awefawfwaf");
        list.add("awef");
        String str = longestWord.findLongestWord("aewfafwafjlwajflwajflwafj", list);
        System.out.println(str);
    }

    /**
     * "aewfafwafjlwajflwajflwafj"
     * ["apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"]
     * 输出：
     * "apple"
     * 预期结果：
     * "ewaf"
     */
}
