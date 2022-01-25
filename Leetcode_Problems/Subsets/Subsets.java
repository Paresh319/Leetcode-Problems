/*
78. Subsets
Medium

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Approach is recursion - The decision for recursion is whether to include the element in the sub set or not ... First case include and recurse.... second case exclude and recurse.
Runtime: 8 ms, faster than 5.53% of Java online submissions for Subsets.
Memory Usage: 38.9 MB, less than 96.28% of Java online submissions for Subsets.
*/
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        
        backtrack(nums, 0, nums.length, l);
        System.out.println(res);
        return res;
    }
    
    public void backtrack(int[] nums, int start, int end, List<Integer> l)
    { 
        if(start == nums.length)
        {
            res.add(new ArrayList(l));
            // System.out.println("here"+res);
            System.out.println("This" + l);
            return ;
        }
              
            l.add(nums[start]);
            backtrack(nums, start+1, end, l);
            l.remove(l.size()-1);
        
        backtrack(nums, start+1, end, l);
        // return res;
    }
    
    
}
