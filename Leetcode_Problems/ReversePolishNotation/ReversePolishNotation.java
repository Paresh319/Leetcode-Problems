package Leetcode_Problems.ReversePolishNotation;

import java.util.ArrayList;
import java.util.HashSet;

class ReversePolishNotation {
    HashSet<String> hs = new HashSet<>();
    public int evalRPN(String[] tokens) {
        ArrayList<String> l = new ArrayList<>();
        for(String s: tokens) {
            l.add(s);
        }
        hs.add("+");
        hs.add("*");
        hs.add("/");
        hs.add("-");
        return recursiveHelper(l);
        
    }

    public int recursiveHelper(ArrayList<String> l) {
        if(l.size() == 1){
            return Integer.valueOf(l.get(0));
        }
        for(int i = 0; i < l.size(); i++) {
            if(hs.contains(l.get(i))) {
                int a = Integer.valueOf(l.get(i-1));
                int b = Integer.valueOf(l.get(i - 2));
                int result = 0;
                if(l.get(i).equals("*")) {
                    result = a*b;
                }
                else if(l.get(i).equals("/")){
                    result = (int)b/a;
                }
                else if(l.get(i).equals("+")){
                    result = a+b;
                    
                }
                else if(l.get(i).equals("-")){
                    result = b-a;
                }
                l.set(i, String.valueOf(result));
                l.remove(i-1);
                l.remove(i-2);
                return recursiveHelper(l);
            }
        }
        return 0;
    }
}
