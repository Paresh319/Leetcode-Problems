package Leetcode_Problems.DesignAddAndSearchWords;

import java.util.HashMap;

public class WordDictionary {
    HashMap<Character, HashMap> hm = new HashMap<Character, HashMap>();
    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        HashMap<Character, HashMap> childNode = hm;
        int i = 0;
        for(i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(childNode.containsKey(c)){
                childNode = childNode.get(c);
            }
            else 
            {
                break;
            }
        }
        while(i < word.length()) {
            childNode.put(word.charAt(i), new HashMap());
            childNode = childNode.get(word.charAt(i));
            i++;
        }
        childNode.put('0', new HashMap());
    }
    
    public boolean search(String word) {
        HashMap<Character, HashMap> childNode = hm;
        int i = 0;
        while(i < word.length()) {
            if(childNode.containsKey(word.charAt(i))) {
                childNode = childNode.get(word.charAt(i));
                i++;
            }
        }
        if(i == word.length()){
            return true;
        }
        return false;
    }
    
}
