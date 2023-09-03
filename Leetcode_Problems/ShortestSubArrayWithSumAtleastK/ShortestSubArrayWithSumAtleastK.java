package Leetcode_Problems.ShortestSubArrayWithSumAtleastK;

public class ShortestSubArrayWithSumAtleastK {
    public int shortestSubarray(int[] nums, int k) {
        // int i = 0, j = 0;
        // int n = nums.length;
        // int min = Integer.MAX_VALUE;
        // int sum = 0;
        // while(j < n) {
        //     while(j  < n && sum <= k) {
        //         sum += nums[j];
        //     }
        //     if(sum >= k) {
        //         min = Math.min(min, j - i + 1);
        //     }
        //     while(i < j && sum > k) {
        //         sum -= nums[i];
        //         min = Math.min(min, j - i + 1);
        //         i++;
        //     }
        // }
        // return min;
        // incorrect
    }
}
