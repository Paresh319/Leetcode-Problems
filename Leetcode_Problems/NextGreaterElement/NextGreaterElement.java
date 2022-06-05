package Leetcode_Problems.NextGreaterElement;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            if(!s.isEmpty() && nums2[i] > s.peek())
            {
                while(!s.isEmpty() && nums2[i] > s.peek())
                {
                    hm.put(s.pop(), nums2[i]);

                }
                
            }
            s.push(nums2[i]);
        }

        while(!s.isEmpty())
        {
            hm.put(s.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hm.get(nums1[i]);
            
        }
        return res;
        
    }
}
