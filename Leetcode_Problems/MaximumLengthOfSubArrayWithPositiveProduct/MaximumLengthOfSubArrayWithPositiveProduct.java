package Leetcode_Problems.MaximumLengthOfSubArrayWithPositiveProduct;

import java.util.concurrent.CountDownLatch;

//Source: https://www.youtube.com/watch?v=vmY9ctncXQI 
/*
 * There are three cases 
 * First case: All elements are positive then the longest length is the length of the array
 * Second Case: There are even number of negative elements in that case too the length is the total length of the array
 * third case: There are odd number of negative numbers which means we have to take the maximum after excluding the last
 * negative element and after excluding the first negative element.
 * 
 * now all these cases are further split when there are zeroes in the array 
 * If there are zeroes then we split the array into as many parts as the zeroes split them and then consider each
 * of the subarrays in the array. then on each of the subarrays we apply the three cases above. 
 * 
 */

public class MaximumLengthOfSubArrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int ans = 0;
        int n = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            int s = i;
            while(s < n && nums[s] == 0)
            {
                s++;
            }
            int e = s;
            int countOfNegative = 0;
            int sn = -1; 
            int en = -1;
            while(e < n && nums[e] != 0)
            {
                if(nums[e] < 0)
                {
                    countOfNegative++;
                    if(sn == -1)
                    {
                        sn = e;
                    }

                    en = e;
                }
                e++;
            }
            if(countOfNegative % 2 == 0)
            {
                ans = Math.max(ans, e - s);
            }
            else
            {
                if(sn != -1) ans = Math.max(ans, e - sn - 1);
                if(en != -1) ans = Math.max(ans, en - s);
            }
        }
        return ans;

       
        
        
    }

    
}
