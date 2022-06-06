package Leetcode_Problems.DailyTemperatures;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stk = new Stack<>();

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while(!stk.isEmpty() && nums[i] > nums[stk.peek()])
            {
                int k = stk.pop();
                answer[k] = i - k;
            }
            stk.push(i);
        }
        return answer;

        
    }

    
}
