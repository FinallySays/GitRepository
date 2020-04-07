//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int size = nums.length;
        int l = 0;
        int r = size - 1;
        int mid = 0;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            mid = l + (r - l) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[l] <= nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
