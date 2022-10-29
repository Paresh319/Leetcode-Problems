package Leetcode_Problems.AndroidUnlockPatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AndroidUnlockPatterns {
    int count = 0;
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    public int numberOfPatterns(int m, int n) {
        
        initializeMap(hm);
        dfs(new HashSet<Integer>(), m, n, 0, 1, "");
        return count;
    
    }
    public void dfs(HashSet<Integer> visited, int minSize, int maxSize, int currentSize, int start, String s) {
        if(s.length() >= minSize && s.length() <= maxSize) {
            count++;
            return;
        }
        if(visited.contains(start))

        visited.add(start);
        for(int i = start + 1; i <= 9; i++) {
            s += String.valueOf(i);
            dfs(visited, minSize, maxSize, currentSize + 1, i, s);
            s = s.substring(0, s.length() - 1);
        }
    }


    public void initializeMap(HashMap<Integer, List<Integer>> hm)
    {
        for(int i = 1; i <= 9; i++)
        {
            hm.put(i, new ArrayList<Integer>());
        }

        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(8);
        hm.get(1).addAll(l);

        l = new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(9);
        hm.get(2).addAll(l);


        l = new ArrayList<>();
        l.add(2);
        l.add(4);
        l.add(7);
        l.add(5);
        l.add(6);
        l.add(9);
        hm.get(3).addAll(l);


        l = new ArrayList<>();
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(5);
        hm.get(4).addAll(l);

        l = new ArrayList<>();
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(6);

        hm.get(5).addAll(l);

        l = new ArrayList<>();
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(5);
        hm.get(6).addAll(l);

        l = new ArrayList<>();
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(2);
        l.add(8);
        hm.get(7).addAll(l);


        l = new ArrayList<>();
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(9);
        l.add(1);
        l.add(3);
        hm.get(8).addAll(l);


        l = new ArrayList<>();
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(2);
        l.add(8);
        hm.get(9).addAll(l);

    }
    
}
