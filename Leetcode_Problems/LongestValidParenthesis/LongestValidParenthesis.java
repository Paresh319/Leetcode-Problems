package Leetcode_Problems.LongestValidParenthesis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class LongestValidParenthesis {
    static int max = 0;
    static HashSet<String> hs = new HashSet<>();
    
    public static int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                open++;
            }
            else {
                close++;
            }
        }
        recursiveHelper(s, open, close);
        return max;
    }
    
    public static void recursiveHelper(String s, int open, int close) {
        if(s.length() == 0 || s.length() <= max || hs.contains(s)) {
            return;
        }
        if(open == close && s.charAt(s.length() - 1) == ')' && s.charAt(0) == '(') {
            if(isValid(s)) {
                max = Math.max(max, s.length());
                return;
            }
        }
        hs.add(s);
        
        if(s.charAt(0) == '(') {
            recursiveHelper(s.substring(1), open - 1, close);
        }
        else {
            recursiveHelper(s.substring(1), open, close - 1);
        }
        if(s.charAt(s.length() - 1) == ')') {
            recursiveHelper(s.substring(0, s.length() - 1), open, close - 1);
        }
        else {
            recursiveHelper(s.substring(0, s.length() - 1), open - 1, close);
        }
    }
    
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack();
        int i = 0;
        HashMap<Character, Character> hm = new HashMap();
        hm.put(')', '(');
        
        while(i < s.length())
        {
            char c = s.charAt(i);
            if(hm.containsKey(c))
            {
                if(stk.isEmpty() || stk.pop() != hm.get(c))
                {
                    return false;
                }
            }
            else 
            {
                stk.push(c);
            }
            i++;
        }
        if(stk.isEmpty())
        {
            return true;
        }
        return false;
        
    }
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))"));
    }

    /*
     * This is the way which will do it better
     * 
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        stk.push(-1);
        int maxAns = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                stk.push(i);
            }
            else {
                stk.pop();
                if(stk.empty()) {
                    stk.push(i);
                }
                else {
                    maxAns = Math.max(maxAns, i - stk.peek());
                }
            }
            i++;
        }
        return maxAns;
        
    }
}
     */
    
}