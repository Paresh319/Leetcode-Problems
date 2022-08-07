package Leetcode_Problems.FindFirstAndLastPosition;

public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int i = 0; int j = nums.length - 1;
        int pos = -1;
        while(i <= j)
        {
            int mid = (i + j)/2;
            if(nums[mid] == target)
            {
                pos = mid;
                break;
            }
            else if(nums[mid] > target)
            {
                j = mid - 1;
            }
            else
            {
                i = mid + 1;
            }
        }
        if(pos == -1)
        {
            return new int[]{-1, -1};
        }
        // System.out.println(pos);
        int pos1 = pos;
        int pos2 = pos;

        int min = 0;
        int max = 0;
        while(pos1 >= 0 && nums[pos1] == target)
        {
            pos1--;
        }
        while(pos2 <= nums.length - 1 && nums[pos2] == target)
        {
            pos2++;
        }
        return new int[]{pos1+1, pos2 - 1};
        
    }
    
}
