package Leetcode_Problems.NumberOfRecentCalls;

import java.util.LinkedList;

public class NumberOfRecentCalls {
    LinkedList<Integer> l = new LinkedList<>();

    public NumberOfRecentCalls() {
        
    }
    
    public int ping(int t) {
        l.addLast(t);
        while(l.getFirst() < t - 3000) {
            l.removeFirst();
        }
        return l.size();
    }
    
}
