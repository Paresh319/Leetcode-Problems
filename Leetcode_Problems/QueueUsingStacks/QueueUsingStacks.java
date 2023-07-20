package Leetcode_Problems.QueueUsingStacks;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    int peekElement = 0;
    boolean first = true;

    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(first) {
            peekElement = x;
            first = !first;
        }
        s1.push(x);
    }
    
    public int pop() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.pop();
        peekElement = s2.peek();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public int peek() {
        return peekElement;
    }
    
    public boolean empty() {
        return s1.isEmpty();
        
    }
}