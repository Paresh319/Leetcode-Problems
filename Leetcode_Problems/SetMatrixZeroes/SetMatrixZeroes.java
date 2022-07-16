package Leetcode_Problems.SetMatrixZeroes;

public class SetMatrixZeroes 
{
    int[][] mat;
    boolean[][] visited;
    public void setZeroes(int[][] matrix) {
        mat = matrix;
        int m = mat.length; 
        int n = mat[0].length;
        visited = new boolean[m][n];
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(!visited[i][j] && mat[i][j] == 0)
                {
                    change(i, j);
                }
            }
        }
    }

    public void change(int row, int col)
    {
        for(int i = 0; i < mat.length; i++)
        {
            if(mat[i][col] == 0)
            {
                continue;
            }
            mat[i][col] = 0;
            visited[i][col] = true;
        }
        for(int i = 0; i < mat[0].length; i++)
        {
            if(mat[row][i] == 0)
            {
                continue;
            }
            mat[row][i] = 0;
            visited[row][i] = true;
        }
    }
}
