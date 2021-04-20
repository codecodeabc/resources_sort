package leetcode.dichotomous;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 */
public class SearchNum {

    public boolean searchMatrix(int[][] matrix, int target) {
            int rowLen = matrix.length;
            int lowLen = matrix[0].length;
            int i = 0;
            int j = 0;
            while (i < rowLen) {
                if (matrix[i][lowLen - 1] < target){
                    i++;
                }else{
                    break;
                }
            }
            if(i < rowLen){
                while (j < matrix[i].length){
                    if (matrix[i][j] != target){
                        j++;
                    }else{
                        break;
                    }
                }
                if(j< matrix[i].length){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
    }

    public static void main(String[] args) {
        SearchNum searchNum = new SearchNum();
        int[][] ints = {
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        boolean b = searchNum.searchMatrix(ints, 3);
        System.out.println(b);
    }
}
