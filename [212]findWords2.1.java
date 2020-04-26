//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Trie trie = new Trie();
    List<String> result = new ArrayList<>();
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int row;
    int col;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        for (String s : words) trie.add(s);
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                if (trie.head.get(board[i][j]) != null) {
                    visited[i][j] = true;
                    dfs(i, j, board, trie.head.get(board[i][j]));
                    visited[i][j] = false;
                }
        result.forEach(System.out::println);
        return result;
    }

    private void dfs(int i, int j, char[][] board, Node curr) {
        for (int index = 0; index < 4; ++index) {
            int r = i + dx[index];
            int c = j + dy[index];
            if (r >= 0 && r < row && c >= 0 && c < col && !visited[r][c] && curr.get(board[r][c]) != null && curr.get(board[r][c]).count > 0) {
                visited[r][c] = true;
                dfs(r, c, board, curr.get(board[r][c]));
                visited[r][c] = false;
            }
        }
        if (curr.end) {
            result.add(curr.val);
            trie.remove(curr.val);
        }
    }

    class Trie {
        Node head;

        public Trie() {
            this.head = new Node();
        }

        public void add(String s) {
            Node curr = head;
            for (char c : s.toCharArray()) {
                if (curr.nodes[c - 'a'] == null)
                    curr.nodes[c - 'a'] = new Node();
                curr = curr.nodes[c - 'a'];
                curr.add();
            }
            curr.end = true;
            curr.val = s;
        }

        public void remove(String s) {
            Node curr = head;
            for (char c : s.toCharArray()) {
                curr.nodes[c - 'a'].count--;
                curr = curr.get(c);
            }
            curr.end = false;
            curr.val = null;
        }
    }


    class Node {
        public Node[] nodes;
        public boolean end;
        public String val;
        public int count;

        public Node() {
            count = 0;
            nodes = new Node[26];
            end = false;
            val = null;
        }

        public Node get(char c) {
            return nodes[c - 'a'];
        }

        public void add() {
            count++;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
