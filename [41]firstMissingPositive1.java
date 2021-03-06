//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; ++i)
            while (nums[i] > 0 && nums[i] <= size && nums[nums[i] - 1] != nums[i]) {
                int index = nums[i] - 1;
                if (index != i) {
                    nums[index] ^= nums[i];
                    nums[i] ^= nums[index];
                    nums[index] ^= nums[i];
                }
            }
        for (int i = 0; i < size; ++i)
            if (nums[i] - 1 != i)
                return i + 1;
        return size + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
