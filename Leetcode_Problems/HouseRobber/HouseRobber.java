class Solution {
    public int rob(int[] nums) {
        int sum = 0, prevsum = 0;
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        int k = helper(nums, 0, memo);
        return k;
    }
    
    public int helper(int[] nums, int i, int[] memo)
    {
        
        if(i > nums.length - 1)
        {
            return 0;
        }
        
        if(memo[i] > -1)
        {
            return memo[i];
        }
        
        memo[i] = Math.max((nums[i] + helper(nums, i+2, memo)), helper(nums, i + 1, memo));
        return memo[i];
        
    }
}
