package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class minStack155 {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public minStack155() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) // 要重复最小值
            minStack.push(val);
    }

    public void pop() {
        int top = stack.pop();
        if(!minStack.isEmpty() && minStack.peek().equals(top)) //保证不空
            minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
