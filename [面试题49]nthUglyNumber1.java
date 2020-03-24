//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 0) return -1;
        if (n == 1) return 1;
        int count = 0;
        int temp = 1;
        int num = 1;
        while (count < n) {
            temp = num;
            while (temp / 2 * 2 == temp) temp /= 2;
            while (temp / 3 * 3 == temp) temp /= 3;
            while (temp / 5 * 5 == temp) temp /= 5;
            if (temp == 1)  count++;
            num++;
        }
        return num - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
