package Leetcode_Problems.OneEdit;

import java.util.HashMap;

public class OneEdit {
    public boolean isOneEditDistance(String s, String t) {

        //calculate length of both the strings
        int m = s.length();
        int n = t.length();
        //if length of t is longer that s then call it in reverse manner
        if(m > n){
            return isOneEditDistance(t, s);
        } 

        //if the distance between length is more than one anyway the string are more than one edit distance apart
        if(n - m > 1){
            return false;
        }

        // if we find a char different then we check if the rest of the string is matching if not we return false
        // there sare two conditions where the length is same and length differs by one both of which cases are handled below
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(m == n){
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                else{
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return m + 1 == n;  
    }
}
