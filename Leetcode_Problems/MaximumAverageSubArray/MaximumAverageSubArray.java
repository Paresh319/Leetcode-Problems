package Leetcode_Problems.MaximumAverageSubArray;

public class MaximumAverageSubArray {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        double sum = 0.0;
        double avg = 0.0;
        double maxAverage = Double.MIN_VALUE;
        while(j < nums.length) {
            if(j == i + k - 1) {
                avg = sum / k;
                maxAverage = Math.max(maxAverage, avg);
                sum -= nums[i];
                i++;
            }
            sum += nums[j];
        }
        return maxAverage;
    }
}
