//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; ++i)
            list.add(nums[i]);
        divide(0, size, list, new ArrayList<Integer>());
        return result;
    }
    
    private void divide(int level, int n, List<Integer> list, ArrayList<Integer> solution) {
        if (level == n) {
            result.add(new ArrayList<>(solution));
            return;
        }
    
        for (Integer i : list) {
            List<Integer> temp = new ArrayList<>(list);
            solution.add(i);
            
            temp.remove(i);
            divide(level + 1, n, temp, solution);
            
            solution.remove(i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
