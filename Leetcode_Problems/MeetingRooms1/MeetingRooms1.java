package Leetcode_Problems.MeetingRooms1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MeetingRooms1 {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0)
        {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
         Stack<int[]> s = new Stack<>();
        s.push(intervals[0]);
        int k = 0;
        int currEndTime = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++)
        {
            // int[] temp = s.peek();
            if(currEndTime > intervals[i][0])
            {
                return false;
            }
            else
            {
                currEndTime = Math.max(currEndTime, intervals[i][1]);
            }
        }
        return true;
        

        
    }
    
    
}
