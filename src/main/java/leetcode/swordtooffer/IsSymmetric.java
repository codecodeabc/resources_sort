package leetcode.swordtooffer;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
//3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 207 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class IsSymmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        // 根节点为null时，即为对称
        if(root == null){
            return true;
        }
        // 对比左右节点是否对称
        return isSymm(root.left,root.right);
    }

    public static boolean isSymm(TreeNode left, TreeNode right) {
        // 都为null 则为对称
        if(left == null && right == null )
            return true;
        // 任一节点为null 或值不相等即 不对称
        if(left == null || right == null || left.val != right.val)
            return false;
        // 递归对称位置的节点
        return isSymm(left.left,right.right) && isSymm(left.right,right.left);
    }
}
