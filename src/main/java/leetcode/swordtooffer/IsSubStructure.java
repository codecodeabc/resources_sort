package leetcode.swordtooffer;


//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
//给定的树 A:
//
// 3
// / \
// 4 5
// / \
// 1 2
//给定的树 B：
//
// 4
// /
// 1
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
// 示例 1：
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
//
//
// 示例 2：
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true
//
// 限制：
//
// 0 <= 节点个数 <= 10000
// Related Topics 树 深度优先搜索 二叉树
// 👍 303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class IsSubStructure {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        //一方是空树则为false
        if(A == null || B == null)
            return false;
        // 当前节点值不等，则遍历A节点子树
        if(A.val != B.val)
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        // 当前值相等，则遍历子树:isSub(A,B),若子树也不相等，再遍历A节点子树且B回溯
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public static boolean isSub(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && isSub(A.left,B.left) && isSub(A.right,B.right);
    }
}
