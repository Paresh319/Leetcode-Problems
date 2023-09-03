package Leetcode_Problems.NumberOfAtoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class NumberOfAtoms {
    
    public String countOfAtoms(String formula) {
        Stack<String> s = new Stack<>();
        int i = 0;
        while(i < formula.length()) {
            String r = "";
            if(formula.charAt(i) == '(') {
                s.push("(");
                i++;
            }
            else if(Character.isDigit(formula.charAt(i))) {
                while(i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    r += formula.charAt(i++);
                }
                int k = Integer.parseInt(r);
                String tmp = s.pop();
                String h = "";
                while(k > 0) {
                    h += tmp;
                    k--;
                }
                s.push(h);
            }
            else if(formula.charAt(i) == ')') {
                String temp = "";
                while(!s.isEmpty() && !s.peek().equals("(")) {
                    temp = s.pop() + temp; 
                }
                s.pop();
                s.push(temp);
                i++;
            }
            else if(!Character.isDigit(formula.charAt(i))) {
                if(i < formula.length() - 1 && formula.charAt(i + 1) >= 'a' && formula.charAt(i + 1) <= 'z') {
                    s.push(formula.substring(i, i + 2));
                    i += 2;
                }
                else {
                    s.push(formula.substring(i, i + 1));
                    i++;
                }
            }
        }
        HashMap<String, Integer> hm = new HashMap<>();
        while(!s.isEmpty()) {
            String temp = s.pop();
            for(int p = 0; p < temp.length(); p++) {
                if(p < temp.length() - 1 && temp.charAt(p+1) >= 'a' && temp.charAt(p+1) <= 'z') {
                    hm.put(temp.substring(p, p+2), hm.getOrDefault(temp.substring(p,p+2), 0) + 1);
                    p+=1;
                }
                else {
                    hm.put(temp.substring(p, p+1), hm.getOrDefault(temp.substring(p, p+1), 0) + 1);
                }
            }
        }
        List<String> l = new ArrayList<>(hm.keySet());
        Collections.sort(l);
        String ret = "";
        for(String m: l) {
            ret += m;
            if(hm.get(m) == 1) {
                continue;
            }
            ret += String.valueOf(hm.get(m));
        }
        return ret;
    }
}
