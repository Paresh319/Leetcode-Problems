package Leetcode_Problems.RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[][] nbrs = new int[][]{{0,1}, {1, 0},{0,-1},{-1, 0}};
    public int orangesRotting(int[][] grid) {
        int level = -1;
        Queue<int[]> q = new LinkedList<int[]>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1)
                {
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0)
        {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int[] temp = q.poll();
                for(int[] p: nbrs)
                {
                    int a = temp[0] + p[0];
                    int b = temp[1] + p[1];
                    if(a >= 0 && b >= 0 && a < m && b < n && grid[a][b] == 1 && !visited[a][b])
                    {
                        visited[a][b] = true;
                        q.offer(new int[]{a, b});
                        freshOranges--;
                    }
                }
            }
            level++;
        }
        if(freshOranges == 0)
        {
            return level;
        }
        return -1;
    }

    
}
