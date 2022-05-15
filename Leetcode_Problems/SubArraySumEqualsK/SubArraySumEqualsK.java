package Leetcode_Problems.SubArraySumEqualsK;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int[] res = new int[nums.length + 1];
        // int sum = 0;
        res[0] = nums[0];
        int count = 0;
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i-1] + res[i-1];
            
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (res[end] - res[start] == k)
                    count++;
            }
        }
        return count;
    }
}
