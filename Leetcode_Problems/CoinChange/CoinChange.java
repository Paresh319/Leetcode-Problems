class Solution {
    HashMap<String, Integer> hm = new HashMap<>();
    public int change(int amount, int[] coins) {
        return change(amount, coins, coins.length - 1);
        
    }
    
    public int change(int amount, int[] coins, int n)
    {
        String key = amount + "-" + n;
        if(hm.containsKey(key))
        {
            return hm.get(key);
        }
        if(amount == 0)
        {
            return 1;
        }
        if(amount < 0 || n < 0)
        {
            return 0;
        }
        int include = change(amount - coins[n], coins, n);
        int exclude = change(amount, coins, n - 1);
        hm.put(key, include+ exclude);
        return hm.get(key);
    }
}
