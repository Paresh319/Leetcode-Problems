package Leetcode_Problems.LongestIncreasingPathInAMatrix;

public class LongestIncreasingPathUsingDfs {
    int[][] nbrs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    int m = 0;
    int n = 0;
    public int longestIncreasingPath(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j));
                
            }
            
        }
        return res;
    }

    public int dfs(int[][] matrix, int row, int col)
    {
        int ans = 0;

        for(int[] p: nbrs)
        {
            int a = row+ p[0];
            int b = col + p[1];
            if(a >= 0 && b >= 0 && a < m && b < n && matrix[row][col] < matrix[a][b])
            {
                ans = Math.max(ans, 1 + dfs(matrix, a, b));
            }
        }
        return ans;
    }
    
}
