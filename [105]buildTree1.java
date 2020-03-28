//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
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
// Related Topics 树 深度优先搜索 数组


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
    private int i = 0;
    private int j = 0;
    Set<Integer> set = new HashSet<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return backTrack(preorder, inorder);
    }
    
    private TreeNode backTrack(int[] preorder, int[] inorder) {
        if (i == preorder.length - 1) {
            set.add(preorder[preorder.length - 1]);
            return new TreeNode(preorder[preorder.length - 1]);
        }
        
        TreeNode curr = new TreeNode(preorder[i]);
        set.add(preorder[i]);
        
        i++;
        if (curr.val == inorder[j]) {
            curr.left = null;
            j++;
        } else
            curr.left = backTrack(preorder, inorder);
        
        if (set.contains(inorder[j])) {
            curr.right = null;
            j++;
        } else
            curr.right = backTrack(preorder, inorder);
        
        
        return curr;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
