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
    int index = 0;
    public TreeNode sortedArrayToBST(int[] nums) {
        int size = nums.length;
        if (size == 0) return null;
        int level = 0;
        int temp = size + 1;
        while (temp != 0) {
            temp >>>= 1;
            level++;
        }
        int left = size - ((1 << level - 1) - 1);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(0);
        queue.offer(head);
        for (int i = 1; i < level - 1; ++i) {
            int length = queue.size();
            for (int j = 0; j < length; ++j) {
                TreeNode curr = queue.poll();
                curr.left = new TreeNode(0);
                curr.right = new TreeNode(0);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        for (int i = 0; i < left; ++i) {
            TreeNode curr = queue.poll();
            curr.left = new TreeNode(0);
            i++;
            if (i < left)
                curr.right = new TreeNode(0);
        }
        midOrder(head, nums);
        return head;
    }

    private void midOrder(TreeNode curr,int[] nums) {
        if (curr == null) return;
        midOrder(curr.left, nums);
        curr.val = nums[index++];
        midOrder(curr.right, nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
