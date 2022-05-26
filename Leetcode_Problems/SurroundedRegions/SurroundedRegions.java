package Leetcode_Problems.SurroundedRegions;

class SurroundedRegions {
    boolean[][] visited;
    int[][] neighbors = new int[][]{{-1,0},{0,1},{1, 0}, {0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < n; i++) {
            if(board[0][i] == 'O')
            {
                dfs(board, 0, i);
            }
            if(board[m-1][i] == 'O')
            {
                dfs(board, m-1, i);
            }
        }

        for(int i = 0; i < m; i++)
        {
            if(board[i][0] == 'O')
            {
                dfs(board, i, 0);
            }
            if(board[i][n-1] == 'O')
            {
                dfs(board, i, n-1);
            }
        }



        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < n ; j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'E')
                {
                    board[i][j] = 'O';
                }

            }
            
        }
        
    }
    
    public void dfs(char[][] board, int row, int col)
    {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col])
        {
            return;
        }
        
        // visited[row][col] = true;
        board[row][col] = 'E';

        for (int[] temp: neighbors) {
            int a = temp[0] + row;
            int b = temp[1] + col; 
            if(a >= 0 && b >= 0 && a < board.length && b < board[0].length && board[a][b] == 'O')
            {
                dfs(board, a, b);
            }
            
                
            
        }
        
    }
}