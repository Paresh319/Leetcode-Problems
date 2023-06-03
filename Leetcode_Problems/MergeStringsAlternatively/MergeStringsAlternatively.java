package Leetcode_Problems.MergeStringsAlternatively;

public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        int i = 0; int j = 0;
        int k = 0;
        String ret = "";
        while(i < word1.length() && j < word2.length()) {
            if(k == 0) {
                ret += word1.charAt(i);
                i++;
                k = 1;
            }
            else {
                ret += word2.charAt(j);
                j++;
                k = 0;
            }
        }
        if(i < word1.length()) {
            while(i < word1.length()) {
                ret += word1.charAt(i++);
            }
        }
        else if(j < word2.length()) {
            while(j < word2.length()) {
                ret += word2.charAt(j++);
            }
        }
        return ret;
    }
}
