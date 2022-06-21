package Leetcode_Problems.MultiplyStrings;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int carry = 0;

        List<String> res = new ArrayList<>();
        int i = num1.length() - 1;
        int j = num2.length();
        
        boolean smaller = false;
        int count = 0;
        // List<String> res = 
        while(i >= 0)
        {

            int temp = Integer.valueOf(num1.charAt(i));
            int product = 0;
            StringBuilder sb= new StringBuilder();
            for(int l = num2.length() - 1; l >= 0; l--)
            {
                product = temp * Integer.valueOf(num2.charAt(l));
                for(int ind = 0; ind < count; ind++)
                {
                    sb.append(0);
                }
                if(product > 9)
                {
                    carry = 1;
                    sb.append(product % 10);
                }
                count++;
            }
        }
        
    }
    
}
