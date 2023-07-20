package Leetcode_Problems.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] a: edges) {
            if(!hm.containsKey(a[0])) {
                hm.put(a[0], new ArrayList<>());
            }
            hm.get(a[0]).add(a[1]);
        }
        for(int i = 0; i < n; i++) {
            int num = bfs
        }
    }
}
