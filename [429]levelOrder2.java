//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        helper(queue, result);
        return result;
    }
    
    public void helper(LinkedList<Node> a, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        while (!a.isEmpty()) {
            Node curr = a.poll();
            list.add(curr.val);
            for (Node node : curr.children)
                queue.offer(node);
        }
        result.add(list);
        if (!queue.isEmpty())
            helper(queue, result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
