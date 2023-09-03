package Leetcode_Problems.MinimizeTotalPriceOfTheTrips;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MInimizetotalPriceOfTheTrips {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        HashMap<Integer, List<Integer>> graph = buildGraph(edges, n);
        HashMap<Integer, Integer> visitCount = new HashMap<>();
        for(int[] trip : trips) {
            dfs(trip[0], trip[1], visitCount, graph);
        }       
    }

    public boolean dfs(int a, int b, HashMap<Integer, Integer> visitCount, HashMap<Integer, List<Integer>> graph) {
        if(a == b) {
            visitCount.put(a, visitCount.getOrDefault(a, 0) + 1);
        }

        boolean found =false;
        for(int m: graph.get(a)) {
            found |= dfs(m, b, visitCount, graph);
            if(found) {break;}
        }

        if(found) {
            visitCount.put(a, visitCount.getOrDefault(a, 0) + 1);
        }
        return found;
    }

    public HashMap<Integer, List<Integer>> buildGraph(int[][] edges, int n) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge:edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
