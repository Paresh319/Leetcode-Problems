package Leetcode_Problems.MaxLengthAfterRemovingOneElement;

public class MaxLengthAfterRemovingOneElement {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0;
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        int length = 0;
        while(j < nums.length) {
            if(nums[j] == 0) {
                if(count == 1) {
                    while(i < nums.length && nums[i] == 1) {
                        i++;
                        length--;
                    }
                    i++;
                    length--;
                    count--;
                }
                else if(count == 0) {
                    count++;
                    length++;
                    j++;
                    maxLength = Math.max(length, maxLength);
                }
            }
            else {
                j++;
                length++;
                maxLength = Math.max(length, maxLength);
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength - 1;
    }
}
