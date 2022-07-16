package Leetcode_Problems.ReverseWordsInAString;

public class ReverseWordsInAString {
   
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            s = s.trim();
            
            for(int i = 0 ;i< s.length(); i++)
            {
                if(s.charAt(i)== ' ')
                {
                    while(s.charAt(i) == ' ')
                    {
                        i++;
                    }
                    sb.append(" ");
                }
                
                sb.append(s.charAt(i));
            }
            String[] ret = sb.toString().split(" ");
            StringBuilder sb1 = new StringBuilder();
            for(int i = ret.length-1; i >=0; i--)
            {
                sb1.append(ret[i]);
                sb1.append(" ");
            }
            return sb1.toString().trim();
        }
    
    


//Second Method
public String reverseWords2(String s) {
    s = s.trim();
    int i = 0;
    String t = "";
    StringBuilder sb = new StringBuilder();
    while(i < s.length())
    {
        while(i < s.length() && s.charAt(i) != ' ')
        {
            sb.append(s.charAt(i));
            i++;
        }
        while(i < s.length() && s.charAt(i) == ' ')
        {
            i++;
        }
        sb.append(' ');
    }
    String temp = sb.toString();
    String[] arr = temp.split(" ");
    String ret = "";
    for(int j = arr.length-1; j >= 0; j--)
    {
        ret += arr[j];
        ret+= " "; 
    }
        
    
    return ret.trim();
}
}