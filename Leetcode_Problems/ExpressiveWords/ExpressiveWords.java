package Leetcode_Problems.ExpressiveWords;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.text.AttributeSet.ColorAttribute;

public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {

        List<List<Integer>> l1 = new ArrayList<>();
        List<List<Integer>> l2 = new ArrayList<>();

        int i = 0;
        int res = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while(i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.valueOf(c));
            temp.add(count);
            l1.add(temp);
        }

        for(String w: words) {
            int j = 0;
            l2 = new ArrayList<>();
            while(j < w.length()) {
                char c = w.charAt(j);
                int count = 0;
                while(j < w.length() && w.charAt(j) == c) {
                    count++;
                    j++;
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(Integer.valueOf(c));
                temp.add(count);
                l2.add(temp);
            }
            if(l1.size() != l2.size()) {
                continue;
            }
            boolean flag = true;
            for(int k = 0; k < l2.size(); k++) {
                List<Integer> l3 = l1.get(k);
                List<Integer> l4 = l2.get(k);
                if(l3.get(0) != l4.get(0)) {
                    flag = false;
                    break;
                }
                else {
                    if(l3.get(1) != l4.get(1)){
                        if(l3.get(1) < l4.get(1) || l3.get(1) < 3) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag) {
                res++;
            }
        }
        return res;
    }
    

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        int i= 0; int j = 0;
        HashSet<Integer> hs;
        int maxLength = Integer.MIN_VALUE;
        while(j < s.length()) {
            hs = new HashSet<>();
            if(hm.containsKey(s.charAt(j))) {
                while(!arrayDeque.isEmpty() && arrayDeque.getFirst() != s.charAt(j)) {
                    arrayDeque.removeFirst();
                }
                arrayDeque.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, arrayDeque.size());
            }
        }
    }
    enum color {
        WHITE,
        GREY,
        BLACK;
    }

    HashMap<Integer, Integer> seen;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] pre: prerequisites) {
            if(!hm.containsKey(pre[0])) {
                hm.put(pre[0], new ArrayList<Integer>());
            }
            hm.get(pre[0]).add(pre[1]);
        }
        for(int i = 0; i < numCourses; i++) {
            seen.put(i, color.WHITE);
        }
        int[] output;// = new int[0];
        for(int i = 0; i < numCourses; i++) {
            dfs(i, hm, new HashSet<Integer>());
            if(!this.isPossible) {
                output = new int[0];
                return output;
            }
            else {
                output= new int[numCourses];
                for(int j = 0; j < numCourses; j++) {
                    output[j] = numCourses - j - 1;
                }
            }
        }
        return output;
        
    }

    public void dfs(int i, HashMap<Integer, Integer> hm) {
        if(seen.get(i) == Color.GREY) {
            isPossible = false;
            return;
        }

        seen.put(i, color.GREY);

        for(int a: hm.get(i)) {
            dfs(a, hm);
            if(!isPossible) {
                return;
            }
        }
        seen.put(i, color.GREY);
    }
}
