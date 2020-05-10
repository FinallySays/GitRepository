//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        int bit = 0;
        for (int i = 0; i < 26; ++i)
            if (count[i] == 1)
                bit |= 1 << i;
        for (int i = 0; i < s.length(); ++i)
            if ((bit & (1 << s.charAt(i) - 'a')) > 0)
                return i;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
