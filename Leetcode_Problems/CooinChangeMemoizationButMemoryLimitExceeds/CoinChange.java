class Solution {
    
    
    public int change(int amount, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        dfs(res, amount, coins, new ArrayList<>(), 0, 0);
        System.out.println(res);
        return res.size();
        
    }
    
    public void dfs(List<List<Integer>> res, int amount, int[] coins, List<Integer> l, int sum, int start)
    {
        if(amount == sum)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        
        if(amount < sum)
            return;
        
        for(int i = start; i < coins.length ; i++)
        {
            l.add(coins[i]);
            
                dfs(res, amount, coins, l, sum + coins[i], i);
                l.remove(l.size()-1);
            
        }
    }
}
