package Leetcode_Problems.FindTheWinner;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerInACircularGame {
    public int findTheWinner(int n, int k) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i =0; i < n; i++) {
            l.add(i+1);
        }
        int p = 0;
        while(l.size() > 1) {
            int a = (p + k - 1)%n;
            p = a;
            l.remove(a);
            n = n - 1;
        }
        return l.get(0);
    }
}
