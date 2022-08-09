package Leetcode_Problems.ExcelSheetColumnNumber;

import java.util.HashMap;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int k = 1;
        for(char i = 'A'; i <= 'Z'; i++)
        {
            hm.put(i, k++);
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur_char = s.charAt(n - 1 - i);
            result += (hm.get(cur_char) * (Math.pow(26, i)));
        }
        return result;
    }
}
