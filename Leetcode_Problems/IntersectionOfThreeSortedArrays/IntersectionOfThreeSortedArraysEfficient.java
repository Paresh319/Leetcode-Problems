package Leetcode_Problems.IntersectionOfThreeSortedArrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArraysEfficient {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j= 0, k = 0;
        List<Integer> l = new ArrayList<>();
        int minElement = 0;
        while(i< arr1.length && j < arr2.length && k < arr3.length)
        {
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k])
            {
                l.add(arr1[i]);
                i++;
                j++;
                k++;
            }
            else
            {
                minElement = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
                if(minElement == arr1[i])
                {
                    i++;
                }
                else if(minElement == arr2[j])
                {
                    j++;
                }
                else
                {
                    k++;
                }
            }
        }
        return l;
    }

    
}
