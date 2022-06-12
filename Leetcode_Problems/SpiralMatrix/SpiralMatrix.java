package Leetcode_Problems.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;
enum Direction{
    right,
    down,
    left,
    up
}

public class SpiralMatrix {
    int[][] visited;
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        visited = new int[matrix.length][matrix[0].length];
        
        dfs(matrix, 0 , 0 , Direction.right);
        return res;
        
    }
    
    public void dfs(int[][] matrix, int row, int col, Direction dir)
    {
        if(dir == Direction.right)
        {
            if(col == matrix[0].length - 1 || visited[row][col + 1])
            {
                dfs(matrix, row + 1, col, Direction.down);
            }
        }
        if(dir == Direction.down)
        {
            if(row == matrix.length - 1)
            {
                dfs(matrix, row , col - 1, Direction.left);
            }

        }
        if(dir == Direction.left)
        {

        }
        if(dir == Direction.up)
        {

        }

        
    }

    
}
