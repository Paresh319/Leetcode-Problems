package Leetcode_Problems.LargestRectangleInAHistogram;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.*;

public class LargestREctangleInAHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        int n = heights.length;
        for (int i = 0; i < heights.length; i++) {
            int l = i;
            int r = i;

            while(l >= 0 && heights[l] >= heights[i])
            {
                l--;
            }
            leftMax[i] = l + 1;
            System.out.println("left" + i +"--"+ leftMax[i]);
            // System.out.println();


            while(r < n && heights[r] >= heights[i])
            {
                r++;
            }
            rightMax[i] = r - 1;
            System.out.println("right" + i+"--"+rightMax[i]);
        }

        int[] totalMax = new int[n];

        for(int i = 0; i < n; i++)
        {
            totalMax[i] = ((i - leftMax[i] + 1) + (rightMax[i] - i + 1)) - 1;
        }

        return Collections.max(Arrays.asList(ArrayUtils.toObject(totalMax)));
        
    }
    
    public static void main(String[] args) {
        LargestREctangleInAHistogram l = new LargestREctangleInAHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
