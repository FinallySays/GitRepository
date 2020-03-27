//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private int[] list;
    private int[] prev;
    
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        list = creatList(n);
        prev = new int[n];
        dfs(0, n, new ArrayList<String>(), list);
        return result;
    }
    
    private void dfs(int level, int n, List<String> strs, int[] list) {
        if (level == n) {
            result.add(new ArrayList<>(strs));
            return;
        }
        
        
        for (int i = 0; i < n; ++i) {
            if (list[i] == 1) {
                String s = creatString(i, n);
                strs.add(s);
                prev[level] = i;
                int[] temp = nextList(level, n);
                
                dfs(level + 1, n, strs, temp);
                
                strs.remove(s);
            }
        }
    }
    
    private int[] nextList(int level, int n) {
        int[] list = creatList(n);
        for (int i = 0; i <= level; ++i ) {
            int curr = prev[i];
            list[curr] = 0;
            if (curr - (level - i + 1) >= 0)
                list[curr - (level - i + 1)] = 0;
            if (curr + (level - i + 1) < n)
                list[curr + (level - i + 1)] = 0;
        }
        return list;
    }
    
    private String creatString(Integer index, int n) {
        String s = "";
        for (int i = 0; i < n; ++i)
            s += i != index ? "." : "Q";
        return s;
    }
    
    private int[] creatList(int n) {
        int[] list = new int[n];
        for (int i = 0; i < n; ++i)
            list[i] = 1;
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
