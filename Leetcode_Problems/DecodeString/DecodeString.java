package Leetcode_Problems.DecodeString;


// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"

public class DecodeString {
    public String decodeString(String s) {
        if(s.length() > 0) {
            char c = s.charAt(0);
            if(Character.isDigit(c)) {
                int a = Integer.valueOf(c);
                String ret = "";
                for(int i = 0; i < a; i++) {
                    ret += decodeString(s.substring(1));
                }
                return ret;
            }
            else if(Character.isAlphabetic(c)) {
                int i = 0;
                StringBuilder sb = new StringBuilder();
                while(i < s.length() && Character.isAlphabetic(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                String ret = sb.toString() + decodeString(s.substring(i));
                return ret;
            }
            else {
                return decodeString(s.substring(1));
            }
        }
        return "";
    }
}
