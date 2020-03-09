//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        if (size < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < size - 2; ++i) {
            if (nums[i] > 0) return result;
            int target = -nums[i];
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1] && j < size - 2) ++j;
                    while (j < k && nums[k] == nums[k - 1]) --k;
                    ++j;
                    --k;
                } else if (nums[j] + nums[k] > target) {
                    while (j < k && nums[k] == nums[k - 1]) --k;
                    --k;
                } else {
                    while (j < k && nums[j] == nums[j + 1] && j < size - 2) ++j;
                    ++j;
                }
            }
            while (i < size - 2 && nums[i] == nums[i + 1]) ++i;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
