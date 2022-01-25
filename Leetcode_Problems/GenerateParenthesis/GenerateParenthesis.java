class Solution {
    List<String> res = new ArrayList<>();
    List<Character> l = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
        
    }
    
    public void dfs(int open, int close, int n)
    {
        if(l.size() == 2*n)
        {
            StringBuilder s = new StringBuilder();
            for(char p: l)
            {
                s.append(p);
            }
            
            res.add(s.toString());
            return;
        }
        
        if(open < n)
        {
            l.add('(');
            dfs(open+1, close, n);
            l.remove(l.size()-1);
        }
        
        if(close < open)
        {
            l.add(')');
            dfs(open, close+1, n);
            l.remove(l.size()-1);
        }
        
        
    }
}
