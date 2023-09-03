package Leetcode_Problems.MinimumMovesToEqualArrayElements;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a , int[] b) {
                return a[0] - b[0];
            }
        });

        for(int i = 0 ; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            pq.offer(new int[]{nums[i], min, max});
        }

        Stack<Integer> stk = new Stack<>();
        int steps = 0;
        while(min != max) {
            while(pq.size() > 1) {
                stk.push(pq.poll()[0]);
            }
            int diff = Math.abs(max - min);
            min = pq.peek()[0];
            max = pq.peek()[0];
            while(!stk.isEmpty()) {
                int a = stk.pop() + diff;
                min = Math.min(min, a);
                max = Math.max(max, a);
                pq.offer(new int[]{a, min, max});
            }
            steps += diff;
        }
        return steps;
    }
    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements m = new MinimumMovesToEqualArrayElements();
        System.out.println(m.minMoves(new int[]{1,2,3}));
    }
}
