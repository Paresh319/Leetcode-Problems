class Solution {
    public int findRotateIndex(int left, int right, int[] nums)
    {
        int pivot = 0;
        
        while(left < right)
        {
            pivot = left + (right - left)/2;
            
            if(nums[pivot] > nums[right])
            {
                left = pivot + 1;
            }
            else
            {
                right = pivot;
            }
        }
        
        return left;
    }
    
    public int bSearch(int left, int right, int[] nums, int target)
    {
        int mid = 0;
        
        while(left <= right)
        {
            mid = left + (right - left)/ 2;
            
            
            if(nums[mid] == target)
            {
                return mid;
            }
            if(target < nums[mid])
            {
                right = mid - 1;
                
            }
            else 
            {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int pivot = findRotateIndex(0, nums.length -1, nums);
        System.out.println(pivot);
        int p = 0;
       
        if(target >= nums[pivot] && target <= nums[nums.length-1])
        {
            p = bSearch(pivot, nums.length - 1, nums, target);
        }
        else
        {
            p = bSearch(0, pivot - 1, nums, target);
        }
       
        return p;
    }
}
