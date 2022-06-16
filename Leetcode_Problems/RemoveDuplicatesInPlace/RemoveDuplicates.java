package Leetcode_Problems.RemoveDuplicatesInPlace;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int start = 0;
        while(j < nums.length)
        {
            while(j + 1 < nums.length && nums[j] == nums[j+1])
            {
                j++;
            }
            nums[start++] = nums[j];
            i = j + 1;
            j = i;
        }
        return start;
    }
}
