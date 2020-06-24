//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] >= target / 3) return nums[0] + nums[1] + nums[2];
        int size = nums.length;
        int minABS = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < size - 2 && nums[i] <= target / 3; ++i) {
            int l = i + 1, r = size - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > target) --r;
                else if (sum < target) ++l;
                else return sum;
                if(Math.abs(sum - target) < minABS) {
                    minABS = Math.abs(sum - target);
                    result = sum;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
