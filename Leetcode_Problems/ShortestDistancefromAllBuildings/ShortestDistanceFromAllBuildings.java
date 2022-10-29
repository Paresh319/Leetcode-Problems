package Leetcode_Problems.ShortestDistancefromAllBuildings;

public class ShortestDistanceFromAllBuildings {
    int[][] distance;
    int[][] nbrs = new int[][]{
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; 
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 || grid[i][j] == 2) {
                    visited[m][n] = true;
                }
            }
        }
        boolean[][] seen = new boolean[m][n];
        seen = visited;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    bfs(distance, visited);
                }
            }
        }
    }

    public void bfs(int[][] distance, boolean[][] visited) {
        
    }
    
}
