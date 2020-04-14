//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[size];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); ++i)
            for (int j = triangle.get(i).size() - 1; j >= 0; --j)
                dp[j] = (j > 0 ? Math.min(dp[j], dp[j - 1]) : dp[j]) + triangle.get(i).get(j);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < size; ++i)
            result = Math.min(result, dp[i]);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
