package Leetcode_Problems.KthLargestString;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestString {
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String> q = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String a, String b)
            {
               if(a.length() == b.length())
               {
                   return a.compareTo(b);
               }
                return Integer.compare(a.length(), b.length());
            }
        });
        for(int i = 0; i < nums.length; i++)
        {
            q.add(nums[i]);
            if(q.size() > k)
            {
                q.poll();
            }
        }
        return q.peek();
    }
    
}
