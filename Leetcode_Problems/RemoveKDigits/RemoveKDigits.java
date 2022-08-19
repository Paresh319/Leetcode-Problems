package Leetcode_Problems.RemoveKDigits;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveKDigits {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b)
        {
            return a - b;
        }
    });
    public String removeKdigits(String num, int k) {
        
        backtrack(num, new StringBuilder(), k, 0);
        return String.valueOf(pq.poll());

        
    }

    public void backtrack(String num, StringBuilder sb, int k, int start)
    {
        if(sb.length() == num.length() - k)
        {
            pq.add(Integer.valueOf(sb.toString()));
            return;
        }

        for(int i = start; i < num.length(); i++)
        {
            sb.append(num.charAt(i));
            backtrack(num, sb, k, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
