//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int s1 = w1.length;
        int s2 = w2.length;
        int[] dp = new int[s2 + 1];
        for (int j = 1; j <= s2; ++j)
            dp[j] = j;
        int prev = 0;
        for (int i = 0; i < s1; ++i) {
            prev = i;
            dp[0] = i + 1;
            for (int j = 1; j <= s2; ++j)
                if (w1[i] == w2[j - 1]) {
                    int temp = dp[j];
                    dp[j] = prev;
                    prev = temp;
                } else
                    dp[j] = Math.min(Math.min(prev, prev = dp[j]), dp[j - 1]) + 1;
        }
        return dp[s2];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
