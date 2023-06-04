package Leetcode_Problems.IsSubsequence;

import java.util.HashMap;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        HashMap<Integer, Character> hm = new HashMap();
        int k = 0;
        for(char c: s.toCharArray()) {
            hm.put(k++, c);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(int m: hm.keySet()) {
            char c = hm.get(m);
            while(i < t.length() && t.charAt(i) != c) {
                i++;
            }
            if(i >= t.length()) {
                break;
            }
            sb.append(t.charAt(i++));
        }
        if(sb.toString().indexOf(s) != -1) {
            return true;
        }
        return false;
    }
    
}
