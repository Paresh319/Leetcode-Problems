package Leetcode_Problems.ValidPalindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replace(" ", "");
        String t = "";
        int i = 0; 
        while(i < s.length())
        {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
            {
                t += s.charAt(i);
            }
        }
        t = t.toLowerCase();
        System.out.println(t);

        i = 0;
        int j = t.length() - 1;
        while(i <= j)
        {
            if(t.charAt(i) != t.charAt(j))
            {
                return false;

            }

        }
        return true;


        
    }
    
}
