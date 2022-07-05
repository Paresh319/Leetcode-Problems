package Leetcode_Problems.FindTheCelebrity;

public class FindTheCelebirty {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int numberOfPeople;
    public int findCelebrity(int n) {
        numberOfPeople = n;
        int[][] arr = new int[n][2];
        int celebrity = -1;
        boolean flag = true;
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
