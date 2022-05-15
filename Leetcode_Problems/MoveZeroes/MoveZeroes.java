package Leetcode_Problems.MoveZeroes;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastPositionofZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 && nums[i] == 0)
            {
                lastPositionofZero = 0;
                continue;
            }
            if(nums[i] > 0 && lastPositionofZero > -1)
            {
                int temp = nums[lastPositionofZero];
                nums[lastPositionofZero] = nums[i];
                nums[i] = temp;
                lastPositionofZero += 1;
            }
        }
    }
    
}
