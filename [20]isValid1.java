//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s == null) throw new NullPointerException("s Is Null");
        char[] chars = s.toCharArray();
        int size = chars.length;
        if (size % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < size; ++i) {
            if (chars[i] != ')' && chars[i] != ']' && chars[i] != '}')
                stack.push(chars[i]);
            else if (stack.isEmpty())
                return false;
            else if (chars[i] == ')') {
                if (stack.pop() != '(')
                    return false;
            } else if (chars[i] == ']') {
                if (stack.pop() != '[')
                    return false;
            } else {
                if (stack.pop() != '{')
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
