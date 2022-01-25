//Using DFS

class Solution {
    List<Character> l = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        
        if(digits.equals(""))
        {
            return res;
        }
        
        
        dfs(digits.toCharArray(), 0);
        return res;
        
    }
    
    public void dfs(char[] arr, int start)
    {
        
        if(l.size() == arr.length)
        {
            StringBuilder s = new StringBuilder();
            for(char p : l)
            {
                s.append(p);
            }
            // String o = l.toString();
            res.add(s.toString());
            return;
        }
        String s = letters.get(arr[start]);
        
        for(int i = 0; i < s.length(); i++)
        {
            l.add(s.charAt(i));
            dfs(arr, start + 1);
            l.remove(l.size()-1);
        }
    }
        
}
