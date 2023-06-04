package Leetcode_Problems.GreatestCommonDivisorOfStrings;

import java.util.HashMap;
import java.util.HashSet;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2)) {
            return str1;
        }
        String smaller = str1.length() > str2.length() ? str2: str1;
        String larger = str1.length() > str2.length() ? str1: str2;
        if(str1.length() == str2.length()) {
            smaller = str1;
            larger = str2;
        }
        String tempSmaller = smaller;
        while(tempSmaller.length() > 0) {
            if(gcd(smaller, tempSmaller) && gcd(larger, tempSmaller)) {
                return tempSmaller;
            }
            else {
                int len = tempSmaller.length();
                tempSmaller = tempSmaller.substring(0, tempSmaller.length() - 1);
            }
        }
        return "";
    }
    public boolean gcd(String a, String b) {
        if(a.length() < b.length()) {
            return false;
        }
        if(a.equals(b)) {
            return true;
        }
        if(a.substring(0, b.length()).equals(b)) {
            return gcd(a.substring(b.length(), a.length()), b);
        }
        return false;
    }
}