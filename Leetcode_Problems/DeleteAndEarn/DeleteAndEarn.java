package Leetcode_Problems.DeleteAndEarn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DeleteAndEarn {
    HashMap<Integer, Integer> hm = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public int deleteAndEarn(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i])) {
                hm.put(nums[i], 0);
            }
            int a = hm.get(nums[i]);
            a += nums[i];
            hm.put(nums[i], a);
        }
        ArrayList<Integer> l = new ArrayList<Integer>(hm.keySet());
        Collections.sort(l);
        int[] memo = new int[l.size()];
        return dfs(hm, 0, l, memo);
    }

    public int dfs(HashMap<Integer, Integer> hm, int index, List<Integer> l, int[] memo) {
        if(index == l.size()) {
            return 0;
        }
        if(memo[index] != 0) {
            return memo[index];
        }
        
        int exclude = dfs(hm, index + 1, l, memo);
        int a = l.get(index);

        Iterator itr = l.iterator();
        while(itr.hasNext()) {
            Integer number = (Integer) itr.next();
            if(number == a+1 || number == a-1) {
                l.remove(number);
            } 
        }
        int include = hm.get(a) + dfs(hm, index + 1, l, memo);

        memo[index] = Math.max(include, exclude);
        return memo[index];
    }
}
