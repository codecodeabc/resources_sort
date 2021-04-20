package leetcode.twopointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 滑动窗口
 * 76. Minimum Window Substring (Hard)
 * 3.6 练习 – 12/143 –
 * 题目描述
 * 给定两个字符串 S 和 T，求 S 中包含 T 所有字符的最短连续子字符串的长度，同时要求时间
 * 复杂度不得超过 O(n)。
 * 输入输出样例
 * 输入是两个字符串 S 和 T，输出是一个 S 字符串的子串。
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class MinWindowSubString {
    /*//存放T字符串的字符记录
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    //记录s字符创窗口字符
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        //len记录最小窗口长度，ansL,ansR记录窗口范围
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            //检查窗口是否已包含T的所有字符
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                //从左边缩小窗口，直到退出while循环
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        //获取 T 字符串记录
        Iterator iter = ori.entrySet().iterator();
        //遍历窗口
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            //每个字符数都不少于T串的字符
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }*/
    //记录 T串  hash表
    static HashMap<Character, Integer> ct = new HashMap<>();
    //记录 窗口 hash表
    static HashMap<Character, Integer> ck = new HashMap<>();

    public static String minWindow(String s, String t) {
        int tlen = t.length();

        //记录 t 串
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            ct.put(c, ct.getOrDefault(c, 0) + 1);
        }
        //记录最小窗口左右边界
        int ansl = -1;
        int ansr = -1;

        //窗口左边界
        int l = 0;
        //窗口右边界，设-1为防止极端，s长度为0
        int r = -1;
        int len = Integer.MAX_VALUE;
        int slen = s.length();
        while (r < slen) {
            r++;
            //窗口包含T串的则 +1
            if (r < slen && ct.containsKey(s.charAt(r))) {
                ck.put(s.charAt(r), ck.getOrDefault(s.charAt(r), 0) + 1);
            }
            //缩小窗口
            while (check() && l <= r) {
                //窗口为最小时，记录
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansl = l;
                    ansr = l + len;
                }
                if (ct.containsKey(s.charAt(l))) {
                    ck.put(s.charAt(l), ck.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansl == -1?"":s.substring(ansl,ansr);
    }

    public static boolean check() {
        Iterator iterator = ct.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if(ck.getOrDefault(key, 0)<value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println( minWindow("ADOBECODEBANC","ABC"));
    }
}
