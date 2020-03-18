//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int area = 0;
        for (int i = 0; i < size; ++i) {
            int len = 1;
            for (int j = i + 1; j < size; ++j)
                if (heights[j] < heights[i])
                    break;
                else
                    len++;
            for (int j = i - 1; j >= 0; --j)
                if (heights[j] < heights[i])
                    break;
                else
                    len++;
                area = Math.max(area, heights[i] * len);
        }
        return area;
    }
    
    
}
//leetcode submit region end(Prohibit modification and deletion)
