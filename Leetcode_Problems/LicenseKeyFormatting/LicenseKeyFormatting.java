package Leetcode_Problems.LicenseKeyFormatting;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
         while(i< s.length())
         {
             if(s.charAt(i) != '-')
             {
                 sb.append(s.charAt(i));
             }
             i++;
         }
         String t = sb.toString();
        t = t.toUpperCase();
         int p = 0;

         int j = t.length() - 1;
         sb = new StringBuilder();

         while(j >= 0)
         {
             if(p < k)
             {
                 sb.append(t.charAt(j));
                 p++;
                 
             }
             else
             {
                 p = 0;
                 sb.append('-');
                 sb.append(t.charAt(j));
                 p++;
                 
             }
             j--;

         }
         return sb.reverse().toString();


        
    }
    
}
