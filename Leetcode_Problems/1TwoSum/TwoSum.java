// 1. Two Sum
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].

// Approach - 
// Using a hashmap to store the complement value as the key
// and using that to retrieve the index of the element

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm  = new HashMap<>();
        
        for(int i = 0 ; i < nums.length; i++)
        {
            int diff = target - nums[i];
            
            if(hm.containsKey(diff) && hm.get(diff) != i)
            {
                return new int[]{i, hm.get(diff)};
            }
            
            hm.put(nums[i], i);
        }
        return null;
    }
}

// Runtime: 1 ms, faster than 99.59% of Java online submissions for Two Sum.
// Memory Usage: 38.9 MB, less than 86.88% of Java online submissions for Two Sum.
// Time - O(n), Space - O(n)