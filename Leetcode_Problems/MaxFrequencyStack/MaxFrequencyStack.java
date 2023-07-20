package Leetcode_Problems.MaxFrequencyStack;

import java.util.HashMap;
import java.util.Stack;

public class MaxFrequencyStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    int maxFreq = 0;
    HashMap<Integer, Stack<Integer>> group = new HashMap<>();

    public MaxFrequencyStack() {
        
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        maxFreq = Math.max(maxFreq, freq.get(val));
        if(!group.containsKey(freq.get(val))) {
            group.put(freq.get(val), new Stack<>());
        }
        group.get(freq.get(val)).push(val);
    }
    
    public int pop() {
        int x = group.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if(group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
        
    }
}
