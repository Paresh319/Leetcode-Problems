package Leetcode_Problems.DecodeString;

import java.util.HashSet;
import java.util.Stack;

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// "3[a2[c]]"

public class DecodeString {
    HashSet<String> hs = new HashSet<>();
    
    public String decodeString(String s) {
        hs.add("0");
        hs.add("1");
        hs.add("2");
        hs.add("3");
        hs.add("4");
        hs.add("5");
        hs.add("6");
        hs.add("7");
        hs.add("8");
        hs.add("9");
       int i = 0;
       Stack<String> stk = new Stack();
        while(i < s.length()) {
            if(s.charAt(i) != ']') {
                stk.push(String.valueOf(s.charAt(i)));
                i++;
            }
            else {
                String r = "";
                while(s.charAt(i) != '[') {
                    r = stk.pop() + r;
                }
                stk.pop();
                String k = "";
                while(hs.contains(stk.peek())){
                    k = stk.pop() + k;
                }
                int count = Integer.valueOf(k);
                while(count > 0) {
                    stk.push(r);
                    count--;
                }
            }
        }
        String result = "";
        while(!stk.isEmpty()) {
            result = stk.pop() + result;
        }
        return result;
    }
}
