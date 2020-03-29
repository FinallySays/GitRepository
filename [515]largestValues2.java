//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索


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
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root != null) dfs(0, root);
        return result;
    }
    
    private void dfs(int level, TreeNode root) {
        if (result.size() <= level) result.add(root.val);
        else result.set(level, Math.max(root.val, result.get(level)));
        
        if (root.left != null) dfs(level + 1, root.left);
        if (root.right != null) dfs(level + 1, root.right);
        
    }
}


