public class KnightProbability {
    public double knightProbability(int n, int k, int row, int column) {
        int nbrs[][] = {{-2, 1}, {-2, -1}, {-1, 2}, {1, 2}, {-1, -2},{1, -2}, {2, 1}, {2, -1}};
        double[][][] dp = new double[k+1][n][n];
        dp[0][row][column] = 1.0;

        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < n; j++) {
                for(int p = 0; p < n; p++) {
                    for(int[] q : nbrs) {
                        int prevX = j + q[0];
                        int prevY = p + q[1];
                        if(prevX >= 0 && prevY >= 0 && prevX < n && prevY < n) {
                            dp[i][j][p] += dp[i-1][prevX][prevY] / 8;
                        }
                    }
                }
            }
        }
        double totalProbability = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += dp[k][i][j];
            }
        }
        return totalProbability;
    }
}
