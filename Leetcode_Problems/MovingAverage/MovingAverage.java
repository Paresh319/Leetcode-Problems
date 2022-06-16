package Leetcode_Problems.MovingAverage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class MovingAverage {

    ArrayDeque<Integer> aq = new ArrayDeque<>();
   int count = 0;
   int capacity;
   int sum = 0;
   
   public MovingAverage(int size) {
       this.capacity = size;
   }
   
   public double next(int val) {
       double ret = 0.0;
       aq.addLast(val);
       count++;
       sum += val;
       if(count <= capacity)
       {
           return (sum * 1.0)/count;
       }
       else
       {
           sum -= aq.poll();
           count--;
           return sum * 1.0/Math.min(capacity,count);
       }
   }
}

/**
* Your MovingAverage object will be instantiated and called as such:
* MovingAverage obj = new MovingAverage(size);
* double param_1 = obj.next(val);
*/