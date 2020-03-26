//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> result = new ArrayList<>();
    private Map<Integer, List<String>> map = creatHashMap();
    
    public List<String> letterCombinations(String digits) {
        int size = digits.length();
        if (size != 0) {
            divide(0, digits, size, "");
        }
        return result;
    }
    
    private void divide(int level,String digits, int k, String s) {
        if (level == k) {
            result.add(s);
            return;
        }
        
        List<String> list = map.get((int)digits.charAt(level) - 48);
        for (String str : list) {
            divide(level + 1, digits, k, s + str);
        }
        
    }
    
    private Map<Integer, List<String>> creatHashMap() {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
