//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (n == 0) return list;
        if (n == 1) {
            list.add("()");
            return list;
        }
        for (String s : generateParenthesis(n - 1)) {
            char[] t = new char[s.length() + 2];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                if (chars[i] == '(') {
                    System.arraycopy(chars, 0, t, 0, i + 1);
                    t[i + 1] = '(';
                    t[i + 2] = ')';
                    System.arraycopy(chars, i + 1, t, i + 3, chars.length - i - 1);
                    set.add(String.valueOf(t));
                }
            }
            set.add(s + "()");
        }
        String[] strs = new String[0];
        for (String s : set.toArray(strs))
            list.add(s);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
