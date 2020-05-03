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
    int[][] row = new int[9][9];
    int[][] col = new int[9][9];
    int[][] squal = new int[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                if (board[i][j] != '.')
                    code(i, j, board[i][j]);
        dfs(0, board);
    }

    private void code(int i, int j, int num) {
        int index = num - '1';
        row[i][index]++;
        col[j][index]++;
        squal[i / 3 * 3 + j / 3][index]++;
    }

    private boolean dfs(int level, char[][] board) {
        if (level == 81)
            return true;
        if (board[level / 9][level % 9] != '.')
            return dfs(level + 1, board);
        else {
            for (int i = '1'; i <= '9'; ++i) {
                if (!canUse(level / 9, level % 9, i))
                    continue;
                code(level / 9, level % 9, i);
                board[level / 9][level % 9] = (char)i;
                if (dfs(level + 1, board))
                    return true;
                else
                    remove(level / 9, level % 9, i, board);
            }
        }
        return false;
    }

    private boolean canUse(int i, int j, int num) {
        int index = num - '1';
        if (row[i][index] > 0 || col[j][index] > 0 || squal[i / 3 * 3 + j / 3][index] > 0)
            return false;
        return true;
    }

    private void remove(int i, int j, int num, char[][] board) {
        int index = num - '1';
        board[i][j] = '.';
        row[i][index]--;
        col[j][index]--;
        squal[i / 3 * 3 + j / 3][index]--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
