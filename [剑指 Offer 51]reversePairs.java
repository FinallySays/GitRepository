//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int result = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return result;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >>> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] prev = new int[mid - l + 1];
        System.arraycopy(nums, l, prev, 0, mid - l + 1);
        int i = 0, j = mid + 1, index = l;
        while (i < prev.length && j <= r) {
            if (prev[i] > nums[j]) {
                result += prev.length - i;
                nums[index++] = nums[j++];
            } else {
                nums[index++] = prev[i++];
            }
        }
        if (i < prev.length)
            System.arraycopy(prev, i, nums, index, r - index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
