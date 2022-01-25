//Learn about priority queue and comparator implementation here
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
        {
            return 0;
        }
        java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return a[0] - b[0];
    }
});
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){
            public int compare(Integer a , Integer b)
            {
                return a - b;
            }
        });
        
        q.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++)
        {
            if(q.peek() <= intervals[i][0])
            {
                q.poll();
            }
            q.add(intervals[i][1]);
        }
            return q.size();
        
        
    }
    
}
