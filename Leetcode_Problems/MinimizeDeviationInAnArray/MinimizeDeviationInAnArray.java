package Leetcode_Problems.MinimizeDeviationInAnArray;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

import javax.xml.transform.Source;

public class MinimizeDeviationInAnArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) ->  b - a);
        for(int p: nums)
        {
            pq.offer(p);
        }
        while(pq.peek() %2 == 0)
        {
            int a = pq.poll();
            pq.offer(a / 2);
        }
        int maximun = pq.peek();
        System.out.println(maximun);

        pq = new PriorityQueue<Integer>((a, b) ->  a - b);
        for(int p: nums)
        {
            pq.offer(p);
        }

        if(pq.peek() % 2 != 0)
        {
            int a = pq.poll();
            pq.offer(a*2);
        }
        int minimum = pq.peek();
        System.out.println(minimum);
        return maximun - minimum;




    }
    
}
