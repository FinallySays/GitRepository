//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] row = new int[9];
    int[] col = new int[9];
    int[] qual = new int[9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    row[i] |= 1 << n;
                    col[j] |= 1 << n;
                    qual[i / 3 * 3 + j / 3] |= 1 << n;
                }
        dfs(0, board);
    }

    private boolean dfs(int level, char[][] board) {
        if (level == 81) return true;
        int r = level / 9;
        int c = level % 9;
        if (board[r][c] != '.') return dfs(level + 1, board);
        int pos = (~(row[r] | col[c] | qual[r / 3 * 3 + c / 3])) & ((1 << 9) - 1);
        while (pos > 0) {
            int temp = pos & (-pos);
            pos &= pos - 1;
            int p = -1;
            while (temp > 0) {
                temp = temp >>> 1;
                p++;
            }
            board[r][c] = (char) (p + '1');
            row[r] |= 1 << p;
            col[c] |= 1 << p;
            qual[r / 3 * 3 + c / 3] |= 1 << p;
            if (dfs(level + 1, board))
                return true;
            else {
                board[r][c] = '.';
                row[r] &= ~(1 << p);
                col[c] &= ~(1 << p);
                qual[r / 3 * 3 + c / 3] &= ~(1 << p);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
