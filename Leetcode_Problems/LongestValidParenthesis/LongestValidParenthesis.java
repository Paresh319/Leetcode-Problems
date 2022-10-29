package Leetcode_Problems.LongestValidParenthesis;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class LongestValidParenthesis {
    HashSet<String> hs = new HashSet<>();

    public int longestValidParentheses(String s) {
         recursiveHelper("", 0, 0, 0, s);
         PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
         });
         return pq.peek().length();

        
    }

    public void recursiveHelper(String a, int open, int close, int index, String s) {
        if(index == s.length()) {
            if(isValid(s)) {
                hs.add(s);
            }
            return;
        }

        if(s.charAt(index) == ')') {
            if(open <= close + 1) {
                recursiveHelper(a + ')', open, close + 1, index + 1, s);
                recursiveHelper(a, open, close, index + 1, s);
            }
        }
        else {
            recursiveHelper(a + '(', open + 1, close, index + 1, s);
            recursiveHelper(a, open, close, index + 1, s);
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack();
        int i = 0;
        HashMap<Character, Character> hm = new HashMap();
        hm.put(')', '(');
                
        while(i < s.length()){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                if(stk.isEmpty() || stk.pop() != hm.get(c)) {
                    return false;
                }
            }
            else  {
                stk.push(c);
            }
            i++;
        }
        if(stk.isEmpty()) {
            return true;
        }
        return false;
    }
}
