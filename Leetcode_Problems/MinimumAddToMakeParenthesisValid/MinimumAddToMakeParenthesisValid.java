package Leetcode_Problems.MinimumAddToMakeParenthesisValid;

import java.util.HashMap;
import java.util.Stack;

public class MinimumAddToMakeParenthesisValid {
    public int minAddToMakeValid(String s) {
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        hm.put(')', '(');
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(!stk.isEmpty() && stk.peek() == hm.get(c))
            {
                stk.pop();
                continue;
            }
            stk.push(c);
        }
        return stk.size();
    }
    
}
