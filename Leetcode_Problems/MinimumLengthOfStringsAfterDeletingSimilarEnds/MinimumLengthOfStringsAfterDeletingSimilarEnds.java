package Leetcode_Problems.MinimumLengthOfStringsAfterDeletingSimilarEnds;

public class MinimumLengthOfStringsAfterDeletingSimilarEnds {
    String ret = "";
    public int minimumLength(String s) {
        ret = s;
        helper(s);
        return ret.length();
    }

    public void helper(String s) {
        if(s.length() <= 0) {
            return;
        }
        int i = 0;
        int j = s.length() - 1;
        if(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                char c = s.charAt(i);
                while(i <= j && s.charAt(i) == c) {
                    i++;
                }
                while(j > i && s.charAt(j) == c) {
                    j--;
                }
                s = s.substring(i, j+1);
                ret = s.length() <= ret.length() ? s : ret;
                helper(s);
            }
        }
    }
}
