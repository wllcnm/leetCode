package org.example.leetcode;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            if (stack2.peek() <= x) {
                int temp = stack2.pop();
                stack2.push(x);
                stack2.push(temp);
            } else {
                stack2.push(x);
            }
        }
    }

    public void pop() {
        stack2.remove(stack1.pop());
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

