package Leetcode_Problems.RemoveInvalidParenthesis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


/*
 * this is the optimized solution which I was able to do on my own!!! Yay!!!
 */


class RemoveInvalidParenthesis {
    HashSet<String> hs = new HashSet<String>();
    HashSet<Character> check = new HashSet<>();
    
    public List<String> removeInvalidParentheses(String s) {
        check.add('(');
        check.add(')');
        recursiveHelper("", 0, 0, 0, s);
        
         PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
         });
        for(String p: hs) {
            pq.offer(p);
        }
        int size = pq.peek().length();
        List<String> res = new ArrayList<>();
        
        while(!pq.isEmpty() && pq.peek().length() == size) {
            res.add(pq.poll());
        }
        return res;
    }
    
    public void recursiveHelper(String a, int open, int close, int index, String s) {
        if(index == s.length()) {
            if(open == close) {
                if(isValid(a)) {
                    hs.add(a);
                }
            }
            return;
        }

        if(s.charAt(index) == ')') {
            if(open >= close + 1) {
                recursiveHelper(a + ')', open, close + 1, index + 1, s);
            }
            recursiveHelper(a, open, close, index + 1, s);
        }
        else if(s.charAt(index) != '(' && s.charAt(index) != ')') {
            recursiveHelper(a + s.charAt(index), open, close, index + 1, s);
        }
        else {
            recursiveHelper(a + '(', open + 1, close, index + 1, s);
            recursiveHelper(a, open, close, index + 1, s);
        }
    }
    
    public boolean isValid(String temp) {
        Stack<Character> stk = new Stack<Character>();
        int i = 0;
        String s = "";
        for(char c: temp.toCharArray()) {
            if(check.contains(c)){
                s += c;
            }
        }
        HashMap<Character, Character> hm = new HashMap<>();
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