package Leetcode_Problems.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        if(numRows == 1)
        {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>(l));
            return ret;
        }
        int numOfCols = 1 + 2 * numRows;
        int[][] res = new int[numRows][numOfCols];

        int start = numOfCols/2;
        res[0][start] = 1;
        res[1][start - 1] = 1;
        res[1][start + 1] = 1;
        for (int i = 2; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if(res[i-1][j] == 0)
                {
                    res[i][j] = res[i-1][j-1] + res[i-1][j+1];
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < res.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < res[0].length; j++) {
                temp.add(res[i][j]);
            }
            ret.add(new ArrayList<>(temp));
            
        }
        return ret;
        
    }
    
}
