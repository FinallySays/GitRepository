//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return result;
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        int res = root.val + Math.max(0, Math.max(l, r));
        result = Math.max(result, Math.max(res, root.val + Math.max(0, l) + Math.max(0, r)));
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
