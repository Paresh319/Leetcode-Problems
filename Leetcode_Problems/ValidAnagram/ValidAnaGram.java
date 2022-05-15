package Leetcode_Problems.ValidAnagram;

import java.util.Arrays;

public class ValidAnaGram {
    public static boolean isAnagram(String s, String t) {

        char[] p = s.toCharArray();
        Arrays.sort(p);
        char[] q = t.toCharArray();
        Arrays.sort(q);
        return (String.valueOf(p).equals(String.valueOf(q)));


        
        
    }
    public static void main(String[] args) {
        String s = "anagram";
        String l = "naagram";
        System.out.println(isAnagram(s, l));
    }

    
}
