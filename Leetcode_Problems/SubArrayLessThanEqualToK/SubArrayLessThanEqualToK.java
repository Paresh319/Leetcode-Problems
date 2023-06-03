package Leetcode_Problems.SubArrayLessThanEqualToK;

import java.util.ArrayList;
import java.util.List;

public class SubArrayLessThanEqualToK {

    public static long countSubArrays(List<Integer> l, int k) {

        int i = 0; int j = 0; long count = 0;
        int product = 1;
        while(j < l.size()) {
            product *= l.get(j);
            if(product <= k) {
                count++;
                j++;
            }
            if(product > k && i < l.size()) {
                product /= l.get(i);
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
    }

}
