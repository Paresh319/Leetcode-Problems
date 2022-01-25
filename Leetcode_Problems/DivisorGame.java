class Solution {
    public boolean divisorGame(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
     return helper(n, dp);
    }
    
    public boolean helper(int n, int[] dp)
    {
        if(n == 1)
        {
            return false;
        }
        
        if(dp[n] != -1)
        {
            if(dp[n] == 1)
                return true;
            else 
                return false;
        }
        
        for(int i = 1; i < n; i++)
        {
            if(n % i == 0)
            {
                if(helper(n - i, dp) == false)
                {
                    dp[n] = 1;
                    return true;
                }
            }
        }
        return false;
        
    }
}
