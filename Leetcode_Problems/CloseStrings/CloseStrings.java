package Leetcode_Problems.CloseStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(char c: word1.toCharArray()) {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }
        for(char c: word2.toCharArray()) {
            if(!hm1.containsKey(c)) {
                return false;
            }
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>(hm1.values());
        ArrayList<Integer> list2 = new ArrayList<Integer>(hm2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }
}
