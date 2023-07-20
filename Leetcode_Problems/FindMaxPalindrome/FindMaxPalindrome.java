package Leetcode_Problems.FindMaxPalindrome;

public class FindMaxPalindrome {
    class Solution {
        int max = Integer.MIN_VALUE;
        public int countPalindromes(String s) {
            recursiveHelper(s, 0);
            return max;
        }
    
        public void recursiveHelper(String s, int index) {
            if(s.length() <= 0) {
                return;
            }
            if(s.length() > max && isPalindrome(s)) {
                max = Math.max(s.length(), max);
                return;
            }
            if(index < s.length()) {
                String s1 = s.substring(0, index) + s.substring(index+1, s.length());
                recursiveHelper(s1, index);
                recursiveHelper(s, index + 1);
            }
        }
    
        public boolean isPalindrome(String str) {
            int i = 0, j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
