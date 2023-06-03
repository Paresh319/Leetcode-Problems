package Leetcode_Problems.MaxNumberOfKSumPairs;

import java.util.HashMap;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(hm);
        int numOfOperations = 0;
        for(int i : nums) {
            if(k-i == i) {
                if(hm.get(i) <= 1) {
                    continue;
                }
            }
            if(hm.containsKey(k-i) && hm.get(i) > 0 && hm.get(k-i) > 0) {
                hm.put(i, hm.get(i) - 1);
                hm.put(k-i, hm.get(k-i) - 1);
                numOfOperations++;
            }
        }
        return numOfOperations;
    }
}
