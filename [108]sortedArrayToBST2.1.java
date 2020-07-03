//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int size = nums.length;
        return solve(nums, 0, size - 1);
    }

    private TreeNode solve(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int size = r - l + 1;
        int temp = size + 1, level = 0;
        while (temp != 0) {
            temp >>>= 1;
            level++;
        }
        int left = size - ((1 << level - 1) - 1);
        int halfLevel = (1 << level - 1) / 2;
        int offset = left > halfLevel ? halfLevel : left;
        int index = ((1 << level - 1) - 1) / 2 + offset + l;
        TreeNode curr = new TreeNode(nums[index]);
        curr.left = solve(nums, l, index - 1);
        curr.right = solve(nums, index + 1, r);
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
