package Leetcode_Problems.StringCompression;

import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

public class StringCompression {
    public static int compress(char[] chars) {
        int i = 0;
       int index = 0;
       
       StringBuilder sb = new StringBuilder();
        
       while(i < chars.length)
       {
           char c = chars[i];
           int count = 0;
           while(i < chars.length && c == chars[i])
           {
               i++;
               count++;
           }
           sb.append(c);
           if(count != 1)
           {
               sb.append(count);
               // count = 1;
               //c = chars[i];
           }
       }

       char[] res = sb.toString().toCharArray();
        System.out.println(sb.toString());
        i = 0;
       while(i < res.length)
       {
           chars[i] = res[i];
           i++;
       }
       return i;
        
               
    }

    public static void main(String[] args) {
        char[] t = {'a','a','b','b','b','c','c','c'};

        System.out.println(compress(t));
        
    }
    
}
