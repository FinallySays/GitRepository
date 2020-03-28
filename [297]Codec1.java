//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计


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
public class Codec {
    
    private StringBuilder sb = new StringBuilder();
    private String[] strs;
    private int index = 0;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
        
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            sb.append("null#");
            return;
        }
        
        sb.append(root.val).append("#");
        
        dfs(root.left);
        dfs(root.right);
        
    }
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        strs = data.split("#");
        return helper();
    }
    
    private TreeNode helper() {
        
        if (strs[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode temp = new TreeNode(Integer.valueOf(strs[index++]));
        
        temp.left = helper();
        temp.right = helper();
        
        return temp;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
