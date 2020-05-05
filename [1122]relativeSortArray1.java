//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        int index = 0;
        for (int i = 0; i < size2; ++i)
            for (int j = index; j < size1; ++j)
                if (arr1[j] == arr2[i])
                    swap(j, index++, arr1);
        fastSort(index, size1 - 1, arr1);
        return arr1;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void fastSort(int l, int r, int[] nums) {
        if (l >= r)
            return;
        int pivot = partion(l, r, nums);
        fastSort(l, pivot - 1, nums);
        fastSort(pivot + 1, r, nums);
    }

    private int partion(int l, int r, int[] nums) {
        int target = nums[r];
        int index = l;
        for (int i = l; i <= r; ++i)
            if (nums[i] <= target)
                swap(i, index++, nums);
        return index - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
