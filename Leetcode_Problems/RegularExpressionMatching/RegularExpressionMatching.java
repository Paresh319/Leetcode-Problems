package Leetcode_Problems.RegularExpressionMatching;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int i = 0; int j = 0;
        return recursion(s, p, i, j);
    }

    public boolean recursion(String s, String p, int i, int j) {
        if(i == s.length() && j == p.length()) {
            return true;
        }
        if(s.charAt(i) == p.charAt(j)) {
            return recursion(s, p, i + 1, j + 1);
        }
        if(p.charAt(i) == '.') {
            return recursion(s, p, i + 1, j + 1);
        }

        if(p.charAt(j) == '*') {
            return recursion(s, p, i + 1, j) || recursion(s, p, i + 1, j + 1);
        }
        return false;

    } 


    
}
