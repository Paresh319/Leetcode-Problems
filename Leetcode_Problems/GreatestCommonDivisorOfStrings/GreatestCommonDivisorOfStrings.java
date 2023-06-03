package Leetcode_Problems.GreatestCommonDivisorOfStrings;

import java.util.HashMap;
import java.util.HashSet;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        HashSet<Character> hs = new HashSet<>();
        int i = 0;
        while(i < str1.length()) {
            hs.add(str1.charAt(i++));
        }
        int j = 0;
        while(j < str2.length()) {
            if(!hs.contains(str2.charAt(j++))) {
                return "";
            }
        }
        String ret = "";
        i = 0;
        int maxLength = 0;
        while(i < str1.length()) {
            ret += str1.charAt(i);
            if(str1.matches(ret) && str2.matches(ret) && maxLength < ret.length()) {
                maxLength = ret.length();
            }
            else 
                break;
        }
        return ret;
    }

    public String gcdOfStrings1(String str1, String str2) {
        if(str1.equals(str2)) {
            return str1;
        }
        String smaller = str1.length() >= str2.length() ? str2: str1;
        String larger = str1.length() > str2.length() ? str1: str2;
        while(smaller.length() > 0) {
            String largerTemp = larger;
            while(largerTemp.length() > 0) {
                if(largerTemp.substring(0, smaller.length()).equals(smaller)) {
                    largerTemp = largerTemp.substring(0, smaller.length());
                }
                else {
                    break;
                }
            }
            if(largerTemp.length() == 0) {
                return smaller;
            }
            smaller = smaller.substring(0, smaller.length() - 1);
        }
        System.out.println();
        return "";
    }
}