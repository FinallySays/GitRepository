//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int size1 = matrix.length;
        if (size1 == 0) return false;
        int size2 = matrix[0].length;
        if (size2 == 0) return false;
        int left = 0;
        int right = size1 - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
//            System.out.println(left + "\t" + right + "\t" + mid);
            if (mid < size1 - 1 && matrix[mid][0] <= target && matrix[mid + 1][0] > target)
                break;
            else if (mid == size1 - 1 && matrix[mid][0] <= target)
                break;
            if (target >= matrix[mid][0])
                left = mid + 1;
            else
                right = mid - 1;
        }

        int row = mid;
        left = 0;
        right = size2 - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[row][mid] == target)
                return true;
            if (matrix[row][mid] < target)
                left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
