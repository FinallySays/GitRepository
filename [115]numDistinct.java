//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。 
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 输入：S = "rabbbit", T = "rabbit"
//输出：3
//解释：
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 输入：S = "babgbag", T = "bag"
//输出：5
//解释：
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int size = chart.length;
        int[] dummy = new int[256];
        Arrays.fill(dummy, -1);
        int[][] dp = new int[chars.length + 1][size + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= chars.length; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= size; ++j) {
                char c = chart[j - 1];
                if (chars[i - 1] != c)
                    if (dummy[c] == -1)
                        dp[i][j] = 0;
                    else dp[i][j] = dp[dummy[c]][j];
                else {
                    int prev = 0;
                    if (dummy[c] != -1) prev = dp[dummy[c]][j];
                    dp[i][j] = prev + dp[i - 1][j - 1];
                }
            }
            dummy[chars[i - 1]] = i;
        }
        return dp[chars.length][size];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
