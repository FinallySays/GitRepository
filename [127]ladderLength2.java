//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 2;


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Set<String> set1 = new HashSet<>();
        Queue<String> q1 = new LinkedList<>();
        Set<String> set2 = new HashSet<>();
        Queue<String> q2 = new LinkedList<>();
        set1.add(beginWord);
        q1.add(beginWord);
        set2.add(endWord);
        q2.add(endWord);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() <= q2.size()) {
                if (doubleDFS(set1, q1, set2,  set)) return result;
            } else if (doubleDFS(set2, q2, set1,  set)) return result;
        }
        return 0;
    }

    private boolean doubleDFS(Set<String> s1, Queue<String> queue, Set<String> s2, Set<String> list) {
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            String s = queue.poll();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; ++j) {
                char temp = chars[j];
                for (char c = 'a'; c <= 'z'; ++c) {
                    chars[j] = c;
                    String newS = new String(chars);
                    if (list.contains(newS) && !s1.contains(newS)) {
                        if (s2.contains(newS))
                            return true;
                        s1.add(newS);
                        queue.offer(newS);
                    }
                }
                chars[j] = temp;
            }
        }
        result++;
        return false;
    }

    private boolean canUse(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i)
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        return count == 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
