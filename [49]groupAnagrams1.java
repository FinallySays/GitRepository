//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String count = counter(str);
            if (!map.containsKey(count)) {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(count, arr);
            } else {
                map.get(count).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
    
    public String counter(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
      String str = "";
        for (int i = 0; i < 26; ++i)
            str = str + count[i] + "#";
        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
