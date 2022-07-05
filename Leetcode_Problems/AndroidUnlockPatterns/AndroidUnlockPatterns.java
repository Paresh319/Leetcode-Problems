package Leetcode_Problems.AndroidUnlockPatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AndroidUnlockPatterns {
    int count = 0;
    public int numberOfPatterns(int m, int n) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        initializeMap(hm);
        for (int i = 1; i <= 9; i++) {
            dfs(hm, new boolean[9], n, 0, i);
        }
    }
    public void dfs(HashMap<Integer, List<Integer>> hm, boolean[] visited, int maxSize, int currentSize, int start)
    {
        if(visited[start])
        {
            return ;
        }
        if(currentSize <= maxSize)
        {
            count++;
        }
        visited[start] = true;

        

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
        l.add(3);
        l.add(1);
        l.add(4);
        l.add(5);
        l.add(6);
        hm.get(3).addAll(l);
        l = new ArrayList<>();
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(2);
        l.add(8);
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
        
        hm.get(7).addAll(l);


        l = new ArrayList<>();
        l.add(4);
        l.add(5);
        l.add(6);
        
        l.add(7);
        l.add(9);
        
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
