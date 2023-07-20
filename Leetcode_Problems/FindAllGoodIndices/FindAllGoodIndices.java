package Leetcode_Problems.FindAllGoodIndices;

import java.util.ArrayList;
import java.util.List;

public class FindAllGoodIndices {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> nonIncreasing = new ArrayList<>();
        List<Integer> nonDecreasing = new ArrayList<>();

        int p = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                nonIncreasing.add(p);
                continue;
            }
            if(nums[i] > nums[i-1]) {
                p = 0;
                nonIncreasing.add(p);
            }
            else {
                nonIncreasing.add(++p);
            }
        }


        p = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) {
                nonDecreasing.add(p);
                continue;
            }
            if(nums[i] > nums[i+1]) {
                p = 0;
                nonDecreasing.add(p);
            }
            else {
                nonDecreasing.add(++p);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nonDecreasing.get(i) >= k && nonIncreasing.get(i) >= k) {
                res.add(i);
            }
        }
        return res;


    }
}
