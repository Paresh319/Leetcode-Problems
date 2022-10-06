package Leetcode_Problems.ValidPalindrome2;

public class ValidPalindrome2 {
    class Solution {
        int count = 0;
        public boolean validPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            return cmpString(s, i, j);  
        }
        
        public boolean cmpString(String s, int i, int j){
            while(i <= j){
                if(s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }
                else
                {
                    if(count > 0){
                        return false;
                    }
                    else{
                        count++;
                        return cmpString(s, i + 1, j) || cmpString(s, i, j - 1);
                    }
                }
            }
            return true;
        }
    }
    
}
