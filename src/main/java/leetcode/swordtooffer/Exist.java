package leetcode.swordtooffer;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 数组 回溯 矩阵
// 👍 358 👎 0
public class Exist {
    public static boolean exist(char[][] board, String word) {
        int m, n;
        if (board == null || (m = board.length) == 0 || board[0] == null || (n = board[0].length) == 0) {
            return false;
        }
        int index = 0;
        // 偏移量
        int[][] to ={
            {0,1},{1,0},{-1,0},{0,-1}
        };
        int [][] mark = new int[board.length][board[0].length];
        for (int i=0;i<mark.length;i++)
            for (int j=0;j<mark[i].length;j++)
                mark[i][j] = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){
                boolean b = existBoard(board, word.toCharArray(), i,j,index,to,mark);
                if(b){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existBoard(char[][] board, char[] word, int i, int j, int index, int[][] to,int [][] mark) {
        if(index >= word.length)
            return true;
        if(board[i][j] == word[index]){
            mark[i][j] = 1;
            for(int k = 0;k<to.length;k++){
                // 在规定范围内 ，且位置未被占用过
                if(i+to[k][0]>=0&&i+to[k][0]<board.length&&j+to[k][1]>=0&&j+to[k][1]<board[i].length&&mark[i+to[k][0]][j+to[k][1]]!=1){
                    boolean b = existBoard(board, word, i + to[k][0], j + to[k][1], index + 1, to, mark);
                    // 返回true 说明找到一条匹配的路径
                    if(b){
                        return b;
                    }else{
                        continue;
                    }
                }
            }
            mark[i][j] = 0;
            return false;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String test = "ABCCED";
        boolean exist = exist(chars, test);
        System.out.println(exist);
    }
}
