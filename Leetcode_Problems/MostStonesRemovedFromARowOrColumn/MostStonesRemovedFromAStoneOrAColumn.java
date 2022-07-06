package Leetcode_Problems.MostStonesRemovedFromARowOrColumn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Pair
{
    int x;
    int y;
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

public class MostStonesRemovedFromAStoneOrAColumn {


    public int removeStones(int[][] stones) {
        HashSet<int[]> visited = new HashSet<int[]>();
        int numOfIslands = 0;
        
        for(int[] a: stones)
        {
            if(!visited.contains(a))
            {
                dfs(a, stones, visited);
                numOfIslands++;
            }
            
        }
        return stones.length - numOfIslands;
        
    }
    
    public void dfs(int[] a, int[][] stones, HashSet<int[]> visited)
    {
        if(visited.contains(a))
        {
            return;
        }
        visited.add(a);
        
        for(int[] b: stones)
        {
            if(b[0] == a[0] || b[1] == a[1])
            {
                dfs(b, stones, visited);
            }
        }
    }
}
