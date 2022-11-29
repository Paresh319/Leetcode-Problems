package Leetcode_Problems.WordSquares;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSquares {
    List<String> res = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    String[] picking;
    public List<List<String>> wordSquares(String[] words) {
        HashSet<String> hs = new HashSet<>();
        for(String p: words){
            hs.add(p);
        }
        picking = new String[words[0].length()];
        int size = words[0].length();
        for(int i = 0; i < words.length; i++) {
            picking[0] = words[i];
            recursiveHelper(hs, words[i], size, String.valueOf(words[i].charAt(0)), 0);
        }
        
        return result;
    }

    public void recursiveHelper(HashSet<String> hs, String start, int size, String s, int index) {
        if(res.size() == size) {
            result.add(res);
            return;
        }
        res.add(start);
        for(int i = 0; i <= index; i++) {

        }

    }
}
    