package Leetcode_Problems.PositionsOfLargeGroups;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> l = new ArrayList<>();
        int i = 0, j = 0;
        int n = s.length();
        while(i < n){
            int count = 0;
            char c = s.charAt(i);
            while(j < n && c == s.charAt(j))
            {
                count++;
                j++;
            }
            if(count >= 3)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j - 1);
                l.add(temp);
            }
            i = j;
        }
        return l;
        
    }
}
