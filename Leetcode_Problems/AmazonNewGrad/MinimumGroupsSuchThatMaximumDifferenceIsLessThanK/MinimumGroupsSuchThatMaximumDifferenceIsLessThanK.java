package Leetcode_Problems.AmazonNewGrad.MinimumGroupsSuchThatMaximumDifferenceIsLessThanK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumGroupsSuchThatMaximumDifferenceIsLessThanK {
    public static int minimumGroups(int[] arr, int k)
    {
        Arrays.sort(arr);
        int n = arr.length;
        int count = 1;
        int start = 0;
        List<Integer> l = new ArrayList<>();
        l.add(start);

        for(int i = 0;i < n; i++)
        {
            if(arr[i] - arr[start] > k)
            {
                count++;
                
                start = i;
                l.add(start);

            }
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
            
        }
        return count;
    }
    
}
