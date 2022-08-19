package Leetcode_Problems.FindAllDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbersInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList();
        
        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
            {
                nums[index] = nums[index] * -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                l.add(i + 1);
            }
        }
        return l;
    }
    
}
