//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; ++i) {
            dp[i][0] = Integer.valueOf(Character.toString(matrix[i][0]));
            result = Math.max(result, dp[i][0]);
        }
        for (int i = 0; i < n; ++i) {
            dp[0][i] = Integer.valueOf(Character.toString(matrix[0][i]));
            result = Math.max(result, dp[0][i]);
        }
        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                if (matrix[i][j] == '1') {
                    int count = 0;
                    if (dp[i - 1][j - 1] > 0)
                        for (int k = 0; k < dp[i - 1][j - 1]; ++k)
                            if (matrix[i - k - 1][j] == '0' || matrix[i][j - k - 1] == '0') {
                                break;
                            } else
                                count++;
                    dp[i][j] = count + 1;
                    result = Math.max(result, dp[i][j]);
                }
        return result * result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
