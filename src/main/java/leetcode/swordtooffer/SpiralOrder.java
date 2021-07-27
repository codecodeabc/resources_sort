package leetcode.swordtooffer;


import java.util.ArrayList;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组 矩阵 模拟
// 👍 276 👎 0
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        ArrayList<Integer> order = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return order.stream().mapToInt(Integer::valueOf).toArray();

        int xMin = 0;
        int yMin = 0;
        int xMax = matrix[0].length - 1;
        int yMax = matrix.length - 1;

        order.add(matrix[0][0]);

        int i = 0, j = 0;
        while (true) {
            while (i < xMax)
                order.add(matrix[j][++i]);

            if (++yMin > yMax)
                break;

            while (j < yMax)
                order.add(matrix[++j][i]);

            if (xMin > --xMax)
                break;

            while (i > xMin)
                order.add(matrix[j][--i]);

            if (yMin > --yMax)
                break;

            while (j > yMin)
                order.add(matrix[--j][i]);

            if (++xMin > xMax)
                break;
        }
        return order.stream().mapToInt(Integer::valueOf).toArray();
    }
}
