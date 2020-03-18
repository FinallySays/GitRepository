//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    
    
    Node node;
    
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        node = new Node(0,Integer.MAX_VALUE);
        
    }
    
    public void push(int x) {
        Node n = new Node(x, Math.min(node.min, x));
        n.next = node;
        node = n;
    }
    
    public void pop() {
        node = node.next;
    }
    
    public int top() {
        return node.val;
        
    }
    
    public int getMin() {
        return node.min;
    }
    
    public class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
