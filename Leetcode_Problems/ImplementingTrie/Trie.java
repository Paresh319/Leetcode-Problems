package Leetcode_Problems.ImplementingTrie;

import java.util.HashMap;

public class Trie {
    
    HashMap<Character, HashMap> origin;

    public Trie() {
        origin = new HashMap<Character, HashMap>();
    }
    
    public void insert(String word) {
        HashMap<Character, HashMap> current = origin;
        int i = 0;
        while(i < word.length())
        {
            if(current.containsKey(word.charAt(i)))
            {
                current = current.get(word.charAt(i));
            }
            else
            {
                current.put(word.charAt(i), new HashMap());
                current = current.get(word.charAt(i));
            }
            i++;
        }
        current.put('0', new HashMap());
    }
    
    public boolean search(String word) {
        HashMap<Character, HashMap> current = origin;
        int i = 0; 
        while(i < word.length())
        {
            if(current.containsKey(word.charAt(i)))
            {
                current = current.get(word.charAt(i));
            }
            else
            {
                return false;
            }
            i++;
        }
        if(current.containsKey('0'))
        {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        HashMap<Character, HashMap> current = origin;
        int i = 0; 
        while(i < prefix.length())
        {
            if(current.containsKey(prefix.charAt(i)))
            {
                current = current.get(prefix.charAt(i));
            }
            else
            {
                return false;
            }
            i++;
        }
        return true;
    }
}
