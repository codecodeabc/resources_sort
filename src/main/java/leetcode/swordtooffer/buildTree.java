package leetcode.swordtooffer;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 479 👎 0
public class buildTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        /**
         * 单节点树
         */
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int prootIndex = 0;
        int irootIndex = 0;
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                // 中序遍历列表 根节点下表
                index = i;
            }
        }
        int llen = index - 0;
        root.left = rebuildTree(preorder, inorder, prootIndex + 1, prootIndex + llen, irootIndex, irootIndex + llen - 1);
        root.right = rebuildTree(preorder, inorder, prootIndex + llen +1 , preorder.length - 1, irootIndex + llen + 1, inorder.length - 1);
        return root;
    }

    private static TreeNode rebuildTree(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright) {
        if (pleft == pright) {
            return new TreeNode(preorder[pleft]);
        }
        /**
         * 判断没有子树的情况
         */
        if(pleft > pright || ileft > iright){
            return null;
        }
        int prootIndex = pleft;
        int irootIndex = ileft;
        int index = ileft;
        for (int i = ileft; i <= iright; i++) {
            if (inorder[i] == preorder[pleft]) {
                // 中序遍历列表 根节点下表
                index = i;
            }
        }
        TreeNode root = new TreeNode(preorder[pleft]);
        int llen = index - ileft;
        root.left = rebuildTree(preorder, inorder, prootIndex + 1, prootIndex + llen, irootIndex, irootIndex + llen - 1);
        root.right = rebuildTree(preorder, inorder, prootIndex + llen +1 , pright, irootIndex + llen + 1, iright);
        return root;
    }

    public static void main(String[] args) {
        /*int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};*/
        int[] preorder = new int[]{1,2};
        int[] inorder = new int[]{2,1};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
