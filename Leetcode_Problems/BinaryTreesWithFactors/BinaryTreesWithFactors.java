package Leetcode_Problems.BinaryTreesWithFactors;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {
    long res = 0;
    HashMap<Integer, Long> memo = new HashMap<>();
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        for(int p: arr) {
            memo.put(p, 0l);
        }
        for(int a: arr) {
            res += recurse(arr, a, memo);
        }
        return (int) (res % 1000000007);
    }

    public long recurse(int[] arr, int a, HashMap<Integer, Long> memo) {
        if(memo.get(a) > 0) {
            return memo.get(a);
        }
        long res1 = 1;
        for(int p: arr) {
            if(p > a){
                break;
            }
            int right = a / p;
            if(memo.containsKey(right) && a % p == 0) {
                res1 += recurse(arr, p, memo) * recurse(arr, right, memo);
            }
        }
        memo.put(a, res1);
            return res1;
    }
}