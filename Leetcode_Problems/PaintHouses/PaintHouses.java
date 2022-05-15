package Leetcode_Problems.PaintHouses;

import java.util.Arrays;

class Solution {
    int[][] memo; 
    public int minCost(int[][] costs) {
        memo = new int[costs.length + 1][costs[0].length+1];
        for(int[] l: memo)
        {
            Arrays.fill(l, -1);
        }
        
        return Math.min(helper(costs, 0, 0), Math.min(helper(costs, 0, 1), helper(costs, 0, 2)));
    }
    
    public int helper(int[][] costs, int row, int col)
    {
        if(memo[row][col] != -1)
        {
            return memo[row][col];
        }
        if(row > costs.length - 1 || col > 2)
        {
            return 0;
        }
        int o = costs[row][col];
        // if(row <= costs.length - 1)
        // {
            
        if(row == costs.length - 1){}
        if(col == 0)
        {
            o +=  Math.min(helper(costs, row + 1, 1), helper(costs,row + 1, 2));
        }
        else if(col == 1)
        {
            o += Math.min(helper(costs, row + 1, 2), helper(costs, row + 1, 0));
        }
        else
        {
            o += Math.min(helper(costs, row + 1, 0), helper(costs, row + 1, 1));
        }
        
        memo[row][col] = o;
        return o;
    }
}
