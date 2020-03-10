//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[m + n];
        int i = 0, j = 0, k = 0;
        for (; i < m && j < n; )
            newNums[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        if (i == m)
            for (; k < m + n; ++k)
                newNums[k] = nums2[j++];
        else
            for (; k < m + n; ++k)
                newNums[k] = nums1[i++];
            for (int l = 0; l < m + n; ++l)
                nums1[l] = newNums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
