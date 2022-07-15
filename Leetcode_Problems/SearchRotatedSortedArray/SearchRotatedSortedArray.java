package Leetcode_Problems.SearchRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

    if (n == 1)
      return nums[0] == target ? 0 : -1;
        
        int pi = findRotateIndex(nums, 0, nums.length-1);
        if(nums[pi] == target)
        {
            return pi;
        }
        System.out.println(pi);
        if (pi == 0)
      return bSearch(nums, 0, n - 1, target);
        
        if(target < nums[0])
        {
            return bSearch(nums, pi, nums.length -1, target);
        }
        return bSearch(nums, 0, pi, target);
    }
    
    public int bSearch(int[] nums, int i, int j, int target)
    {
        while(i <= j)
        {
            int mid = (j+i)/2;
            
            if(nums[mid] == target)
            {
                return mid;
            }
            else 
            {
                if(target > nums[mid]){
                    i = mid + 1;
                }
                else
                {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public int findRotateIndex(int[] nums, int i, int j)
    {
        if(nums[i] < nums[j])
        {
            return 0;
        }
        while(i <= j)
        {
            int mid = (j + i) / 2;
            if(nums[mid] > nums[mid + 1])
            {
                return mid + 1;
            }
            else 
            {
                if(nums[i] > nums[mid])
                {
                    j = mid - 1;
                }
                else
                {
                    i = mid + 1;
                }
            }
        }
        return 0;
    }
}