package Leetcode_Problems.SpiralMatrix;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.List;
enum Direction{
    right,
    down,
    left,
    up
}

public class SpiralMatrix {
    boolean[][] visited;
    int[][] directions = {{0,1}, {1,0},{0,-1},{-1,0}};
    int currentDirection = 0;
    int changeDirection = 0;
    List<Integer> res = new ArrayList<>();
    int row = 0;
    int col = 0;
    int m = 0;
    int n =0;
    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        res.add(matrix[0][0]);
        matrix[0][0] = 101;

        while(changeDirection < 2)
        {
            while(row + directions[currentDirection][0] < m && col + directions[currentDirection][1] < n && 
            row + directions[currentDirection][0] >= 0 && col + directions[currentDirection][1] >= 0 &&
            matrix[row+ directions[currentDirection][0]][col + directions[currentDirection][1]] != 101)
            {
                changeDirection = 0;
                row = row + directions[currentDirection][0];
                col = col + directions[currentDirection][1];
                res.add(matrix[row][col]);
                matrix[row][col] = 101;
            }
            currentDirection = (currentDirection + 1) % 4;
            changeDirection++;
        }
        return res;
        
    }

    
}
