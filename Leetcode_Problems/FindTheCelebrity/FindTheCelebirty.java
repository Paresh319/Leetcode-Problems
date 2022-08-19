package Leetcode_Problems.FindTheCelebrity;

public class FindTheCelebirty {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution {
    private int numberOfPeople;

    public boolean knows(int a, int b)
    {
        return true; //if(a knows b)
        //or false if a does not know b;
        
        // API provided in the question on leetcode

    }
    public int findCelebrity(int n) {
        numberOfPeople = n;
        
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i)) {
                return i;
            }
            
        }
        return -1;
        
    }
    
    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; 
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
}
    
}
