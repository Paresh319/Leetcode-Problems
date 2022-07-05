package Leetcode_Problems.WordSearch2;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    int m = 0;
    int n = 0;
    int[][] neighbors = {{0,1},{-1,0},{0,-1},{1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        for (int k = 0; k < words.length; k++) 
        {
            char c = words[k].charAt(0);
            for(int i = 0; i < board.length; i++)
            {
                for(int j = 0; j < board[0].length; j++)
                {
                    if(board[i][j] == c)
                    {
                        if(dfs(board, i, j, words[k], 0, new boolean[m][n]) && !res.contains(words[k]))
                        {
                            res.add(words[k]);
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited)
    {
        if(index == word.length() - 1)
        {
            return true;
        }
        if(word.charAt(index) != board[i][j])
        {
            return false;
        }
        visited[i][j] = true;
        for(int[] p : neighbors)
        {
            int a = p[0] + i;
            int b = p[1] + j;
            if(a >= 0 && b >= 0 && a < m && b < n && !visited[a][b] && board[a][b] == word.charAt(index + 1))
            {
                if(dfs(board, a, b, word, index + 1, visited))
                {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}