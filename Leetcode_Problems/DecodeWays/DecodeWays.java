package Leetcode_Problems.DecodeWays;

import java.util.HashMap;

class Solution {
    HashMap<Character, Integer> hm = new HashMap<>();
    int count = 0;
    
    public int numDecodings(String s) {
        init(hm);
        recursiveHelper(s, 0, hm);
    }

    public void recursiveHelper(String s, int start, HashMap<Character, Integer> hm) {
        if(s.charAt(0) == '0') {
            return;
        }
        if(start == s.length()) {
            count++;
            return;
        }

        recursiveHelper(s, start + 1, hm);
        if(Integer.valueOf(s.substring(0, 2)) <= 26) {
            recursiveHelper(s, start + 2, hm);
        }
    }
    
    public void init(HashMap<Character, Integer> hm) {
        hm.put('A' , 1);
        hm.put('B' , 2);
        hm.put('C' , 3);
        hm.put('D' , 4);
        hm.put('E' , 5);
        hm.put('F' , 6);
        hm.put('G' , 7);
        hm.put('H' , 8);
        hm.put('I' , 9);
        hm.put('J' , 10);
        hm.put('K' , 11);
        hm.put('L' , 12);
        hm.put('M' , 13);
        hm.put('N' , 14);
        hm.put('O' , 15);
        hm.put('P' , 16);
        hm.put('Q' , 17);
        hm.put('R' , 18);
        hm.put('S' , 19);
        hm.put('T' , 20);
        hm.put('U' , 21);
        hm.put('V' , 22);
        hm.put('W' , 23);
        hm.put('X' , 24);
        hm.put('Y' , 25);
        hm.put('Z' , 26);


    }
}
