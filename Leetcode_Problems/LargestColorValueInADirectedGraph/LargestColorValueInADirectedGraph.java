package Leetcode_Problems.LargestColorValueInADirectedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LargestColorValueInADirectedGraph {
    HashMap<Integer, Character> color = new HashMap<>();
    public int largestPathValue(String colors, int[][] edges) {
        
        for(int i = 0; i < colors.length(); i++) {
            color.put(i, colors.charAt(i));
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] p: edges) {
            if(!graph.containsKey(p[0])) {
                graph.put(p[0], new ArrayList<>());
            }
            graph.get(p[0]).add(p[1]);
        }
        boolean isPossible = true;
        int max = 0;
        for(int i = 0; i < colors.length(); i++) {
            isPossible = true;
            HashMap<Character, Integer> hm = new HashMap<>();
            dfs(i, graph, new boolean[colors.length()], hm, isPossible);
            if(!isPossible) {
                return -1;
            }
            max = Math.max(max, Collections.max(hm.values()));
        }
        return max;
    }

    public void dfs(int i, HashMap<Integer, List<Integer>> graph, boolean[] visited, HashMap<Character, Integer> hm, boolean isPossible) {
        if(visited[i]) {
            isPossible = false;
            return;
        }
        visited[i] = true;
        hm.put(color.get(i), hm.getOrDefault(color.get(i), 0) + 1);
        for(int m: graph.get(i)) {
            dfs(m, graph, visited, hm, isPossible);
            if(!isPossible) {
                return;
            }
        }
    }
}
