package Leetcode_Problems.AddBinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] a2 = b.toCharArray();

        int[] a4 = new int[a1.length];
        int[] a5 = new int[a2.length];

        for(int i = a1.length - 1; i >= 0; i--)
        {
            a4[i - a1.length + 1] = a1[i] - 'a';
        }

        for(int i = a2.length - 1; i >= 0; i--)
        {
            a5[i - a2.length + 1] = a2[i] - 'a';
        }


        int maxLen = Math.max(a.length(), b.length());
        int[] a3 = new int[maxLen + 1];
        int carry = 0;

        int i = 0;
        while(i < a3.length)
        {
            int x = i < a4.length? a4[i] : 0;
            int y = i < a5.length? a5[i] : 0;
            int z = x + y;
            if(z == 0)
            {
                a3[i] = 0;
                carry = 0;
            }
            else if(z == 1)
            {
                carry = 0;
                a3[i] = 1;
            }
            else if(z == 2)
            {
                carry = 1;
                a3[i] = 0;
            }
            else{
                carry = 1;
                a3[i] = 1;
            }
            i++;
        }
        String ret = "";
        for(int j = 0; j < a3.length - 1; j++)
        {
            ret += String.valueOf(a3[j]);
        }
        if(carry > 0)
        {
            ret += "1";
        }
    return ret;
    }
    
}
