package Leetcode_Problems.MaxNumberOfFishInAGrid;

public class MaxNumberOfFishInAGrid {
    int m = 0;
    int n = 0;
    int[][] nbrs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int findMaxFish(int[][] grid) {
        int maxFish = Integer.MIN_VALUE;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] > 0) {
                    int ret = dfs(i, j, grid, new boolean[m][n]);
                    maxFish = Math.max(maxFish, ret);
                }
            }
        }
        return maxFish;
    }
    public int dfs(int i, int j, int[][] grid, boolean[][] visited) {

        visited[i][j] = true;
        int ret = 0;
        for(int[] p: nbrs) {
            int a = i + p[0];
            int b = j + p[1];
            if( a >= 0 && b >= 0 && a < m && b < n && grid[a][b] != 0 && !visited[a][b]) {
                ret += grid[i][j] + dfs(a, b, grid, visited);
            }
        }
        visited[i][j] = false;
        return ret;
    }
}
