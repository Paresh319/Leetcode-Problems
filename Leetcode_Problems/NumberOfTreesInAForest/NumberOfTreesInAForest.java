package Leetcode_Problems.NumberOfTreesInAForest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//  {{0, 1}, {0, 2}, {3, 4}};
public class NumberOfTreesInAForest {
    int count = 0;
    public int numTrees(int[][] edges) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for(int[] p: edges) {
            if(!hm.containsKey(p[0])) {
                hm.put(p[0], new ArrayList<Integer>());
            }
            hm.get(p[0]).add(p[1]);
            visited.putIfAbsent(p[0], false);
            visited.putIfAbsent(p[1], false);
        }

        ArrayList<Integer> l = new ArrayList(hm.keySet());
        int trees = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int a : l) {
            if(visited.get(a) == false) {
                count = 0;
                dfs(a, hm, visited);
                maxCount = Math.max(count, maxCount);
                trees++;
            }
        }
        return trees;
    }

    public void dfs(int a, HashMap<Integer, List<Integer>> hm, HashMap<Integer, Boolean> visited) {

        if(visited.get(a) == true) {
            return;
        }
        visited.put(a, true);
        count++;
        if(hm.containsKey(a)) {
            for(int b: hm.get(a)) {
                dfs(b, hm, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {3, 4}};
        NumberOfTreesInAForest a = new NumberOfTreesInAForest();
        System.out.println(a.numTrees(edges));
    }
}
