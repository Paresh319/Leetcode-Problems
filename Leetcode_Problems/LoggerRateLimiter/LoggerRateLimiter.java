package Leetcode_Problems.LoggerRateLimiter;

import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String, Integer> hm = new HashMap<>();

    public LoggerRateLimiter() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message)) {
            int t = hm.get(message);
            if(timestamp >= t + 10) {
                hm.put(message, timestamp);
                return true;
            }
            else {
                return false;
            }
        }
        hm.put(message, timestamp);
        return true;
    }

    public HashMap<String, Integer> getHm() {
        return hm;
    }

    public void setHm(HashMap<String, Integer> hm) {
        this.hm = hm;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */