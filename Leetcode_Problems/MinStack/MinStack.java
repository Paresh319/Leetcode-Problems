package Leetcode_Problems.MinStack;

import java.util.Stack;

public class MinStack{
    Stack<int[]> s ;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty())
        {
            s.push(new int[]{val, val});
        }
        else{
            int tempMin = s.peek()[1];
            s.push(new int[]{val, Math.min(val, tempMin)});
        }
        
    }
    
    public void pop() {
        s.pop();
        
    }
    
    public int top() {
        return s.peek()[0];
        
    }
    
    public int getMin() {
        return s.peek()[1];
        
    }
    
    public static void main(String[] args) {
        
    }
}