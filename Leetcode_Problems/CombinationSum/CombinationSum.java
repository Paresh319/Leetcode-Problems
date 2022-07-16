package Leetcode_Problems.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        backtrack(new ArrayList<Integer>(), target, 0, candidates);
        return res;
    }
    public void backtrack(List<Integer> l, int target, int index, int[] candidates)
    {
        if(target == 0)
        {
            res.add(new ArrayList<Integer>(l));
            return;
        }
        else if(target < 0)
        {
            return ;
        }
       
        for(int i = index; i < candidates.length; i++)
        {
            l.add(candidates[i]);
            backtrack(l, target - candidates[i], i, candidates);
            l.remove(l.size() - 1);
        }
    }
}
