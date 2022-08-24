package Leetcode_Problems.ClimbStairs;

public class ClimbStairs {
    int[] dp;
    
    public int climbStairs(int n) {
       
        dp = new int[n+1];
        return climb(n);
        
    }
    public int climb(int n)
    {
         if(n <= 1)
        {
            return 1;
        }
        if(dp[n] != 0)
        {
            return dp[n];
        }
        
        int a = climb(n-1);
        int b = climb(n-2);
        dp[n] = a + b;
        return dp[n];
    }


    //bottom up
    public int climbStairs1(int n) {
        if(n <= 1)
        {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n - 1];
        // return climb(n);
    }
    
}
