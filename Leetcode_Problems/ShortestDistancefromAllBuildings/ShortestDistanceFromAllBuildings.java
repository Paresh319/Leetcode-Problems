package Leetcode_Problems.ShortestDistancefromAllBuildings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

class Solution {
    int[][] nbrs;
    int minDistace = 0;;
    int m = 0;
    int n = 0;
    HashMap<String, Integer> hm;

    public int shortestDistance(int[][] grid) {
        nbrs = new int[][]{
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    hm = new HashMap<>();

     minDistace = Integer.MAX_VALUE;
        m = grid.length;
        n = grid[0].length;
        int[][] distance = new int[m][n];
        HashSet<int[]> hs = new HashSet<>();
        HashSet<int[]> setOfLands = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    hs.add(new int[]{i, j});
                }
                if(grid[i][j] == 0) {
                    setOfLands.add(new int[]{i, j});
                }
            }
        }

        for(int[] a: hs) {
           int[][] ret = bfs(grid, new int[m][n], a[0], a[1], 0);
           for(int i = 0; i < m; i++) {
               for(int j = 0; j < n; j++) {
                   distance[i][j] = distance[i][j] + ret[i][j];
               }
           }
        }
        for(String k: hm.keySet()) {
            if(hm.get(k) == hs.size()) {
                String[] arr = k.split("-");
                int p = Integer.valueOf(arr[0]);
                int q = Integer.valueOf(arr[1]);
                minDistace = Math.min(minDistace, distance[p][q]);
            }
        }
        
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         String chck = i + "-" + j;
        //         if(grid[i][j] != 1 && grid[i][j] != 2 && (hm.get(chck) != null && hm.get(chck) == hs.size())) {
        //              minDistace = Math.min(minDistace, distance[i][j]);
        //         }
        //     }
        // }
        return minDistace == 0 || minDistace == Integer.MAX_VALUE ? -1: minDistace;
    }

    public int[][] bfs(int[][] grid, int[][] distance, int row, int col, int dist) {
        Queue<int[]> q = new LinkedList<int[]>();
        String temp = row + "-" + col;
        q.add(new int[]{row, col});
        HashSet<String> visited = new HashSet<>();
        visited.add(temp);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] d = q.poll();
                for(int[] nbr: nbrs) {
                    int a = nbr[0] + d[0];
                    int b = nbr[1] + d[1];
                    String check = a + "-" + b;
                    if(a < m && b < n && a >= 0 && b >= 0 && grid[a][b] != 1 && grid[a][b] != 2 && !visited.contains(check)) {
                        q.add(new int[]{a, b});
                        distance[a][b] = distance[a][b] + distance[d[0]][d[1]] + 1;
                        String t = a + "-" + b;
                        visited.add(t);
                        if(!hm.containsKey(t)) {
                            hm.put(t, 0);
                        }
                        hm.put(t, hm.get(t) + 1);
                    }
                }
            }
        }
        return distance;
    }
}