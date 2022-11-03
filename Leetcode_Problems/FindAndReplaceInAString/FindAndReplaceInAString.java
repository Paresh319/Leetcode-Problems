package Leetcode_Problems.FindAndReplaceInAString;

import java.util.HashMap;

class FindAndReplaceInAString {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        for(int i = 0; i < indices.length; i++) {
            if(s.startsWith(sources[i], indices[i])) {
                hm.put(indices[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();) {
            if(hm.containsKey(i)) {
                sb.append(targets[hm.get(i)]);
                i = i + sources[hm.get(i)].length();
            }
            else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
        
    }
}