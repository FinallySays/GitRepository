//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        int ini = 1 << size;
        for (int i = 0; i < Math.pow(2, size); ++i) {
            String s = Integer.toBinaryString(i | ini).substring(1);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < s.length(); ++j)
                if (s.charAt(j) == '1')
                    list.add(nums[j]);
            result.add(list);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
