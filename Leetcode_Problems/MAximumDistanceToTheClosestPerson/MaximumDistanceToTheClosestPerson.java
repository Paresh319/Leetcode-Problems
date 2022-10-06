package Leetcode_Problems.MAximumDistanceToTheClosestPerson;

public class MaximumDistanceToTheClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int count = -1;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                count = 0;
            }
            leftMax[i] = count;
            if(count >= 0){
                count++;
            }
        }

        count = -1;
        for(int i = n - 1; i >= 0; i--){
            if(seats[i] == 1){
                count= 0;
            }
            rightMax[i] = count;
            if(count >= 0){
                count++;
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            int a = 0;
            if(leftMax[i] < 0 || rightMax[i] < 0){
                a = Math.max(leftMax[i], rightMax[i]);
            }
            else 
            {
               a = Math.min(leftMax[i], rightMax[i]);
            }
            max = Math.max(max, a);
        }
        return max;
        
    }
    
}
