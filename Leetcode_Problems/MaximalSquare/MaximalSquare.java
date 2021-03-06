package Leetcode_Problems.MaximalSquare;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxlen = 0;
        for(int i = 1; i <= matrix.length; i++)
        {
            for(int j = 1; j <= matrix[0].length; j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxlen = Math.max(maxlen , dp[i][j]);
                }
            }
        }
        return maxlen*maxlen;
    }
}
    
   
