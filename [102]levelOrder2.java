//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) dfs(0, root);
        return result;
    }
    
    private void dfs(int level, TreeNode root) {
        if (result.size() == level)
            result.add(new ArrayList<>());
        
        result.get(level).add(root.val);
        
        if (root.left != null) dfs(level + 1, root.left);
        if (root.right != null) dfs(level + 1, root.right);
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
