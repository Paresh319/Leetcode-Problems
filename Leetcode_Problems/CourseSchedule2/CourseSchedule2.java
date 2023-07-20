package Leetcode_Problems.CourseSchedule2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule2 {
    public ArrayList<Integer> findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] a: prerequisites) {
            if(!hm.containsKey(a[0])) {
                hm.put(a[0], new ArrayList<Integer>());
            }
            hm.get(a[0]).add(a[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            ArrayList<Integer> l = dfs(i, numCourses, hm);
            if(l.size() == numCourses) {
                return l;
            }
        }
    }

    public ArrayList<Integer> dfs(int start, )
}
