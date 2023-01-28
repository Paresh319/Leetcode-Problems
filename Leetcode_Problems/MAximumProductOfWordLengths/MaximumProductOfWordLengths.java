package Leetcode_Problems.MAximumProductOfWordLengths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaximumProductOfWordLengths {
    
    public int maxProduct(String[] words) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String a: words) {
            hm.putIfAbsent(a, new ArrayList<>());
            HashSet<Character> a1 = new HashSet<>();
            HashSet<Character> a2 = new HashSet<>();
            for(char c: a.toCharArray()) {
                a1.add(c);
            }
            for(int i = 0; i < words.length; i++) {
               
                if(words[i].equals(a)) {
                    continue;
                }
                String b = words[i];
                boolean flag= true;
                for(char p: b.toCharArray()) {
                    if(a1.contains(p)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    hm.get(a).add(b);
                }
            }
        }

        int maxProduct = 0;

        for(String a: words) {
            List<String> l = hm.get(a);
            for(String p: l) {
                maxProduct = Math.max(maxProduct, p.length() * a.length());
            }
        }
        return maxProduct;
    }
    
}
