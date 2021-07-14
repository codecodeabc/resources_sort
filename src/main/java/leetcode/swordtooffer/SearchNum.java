package leetcode.swordtooffer;

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
        int m, n;
        if (matrix == null || (m = matrix.length) == 0 || matrix[0] == null || (n = matrix[0].length) == 0)
            return false;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                --j;
            else
                ++i;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchNum searchNum = new SearchNum();
        int[][] ints = {
                {1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        };
        boolean b = searchNum.searchMatrix(ints, 5);
        System.out.println(b);
    }
}
