package Leetcode_Problems.StringPalindromes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StringPalindromes {
    HashMap<Integer, Integer> visited = new HashMap<>();
    HashSet<String> hs = new HashSet<String>();
    

    String[] arr = {"00100", "00000", "00100", "01010", "01110", "10001", "10101", "11011", "11111"};
    int count = 0;
    public int countOfPalindromes(String s) {
       for(String k: arr) {
        hs.add(k);
       }
        for(int i = 0; i < s.length(); i++) {
            count = 0;
            recursiveHelper(s, i, new StringBuilder());
        }
        int sum = 0;
        System.out.println(visited);
        for(int a: visited.keySet()) {
            sum += (visited.get(a) % 1000000007);
        }
        return sum;
    }

    public void recursiveHelper(String s, int index, StringBuilder sb) {
        if(index >= s.length() - 1) {
            if(hs.contains(sb.toString())) {
                count++;
            }
            return;
        }
        if(visited.containsKey(index)) {
            return;
        }

        if(sb.length() == 5) {
            if(hs.contains(sb.toString())) {
                count++;
            }
            return;
        }
        recursiveHelper(s, index + 1, sb);
        sb.append(s.charAt(index));
        recursiveHelper(s, index + 1, sb);
        visited.put(index, count);
    }
    public static void main(String[] args) {
        String s = "0100110";
        StringPalindromes obj = new StringPalindromes();
        System.out.println(obj.countOfPalindromes(s));
    }

    public int someMethod() {
        List<List<Integer>> arr = new ArrayList<>();
        Collections.sort(arr, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) - b.get(0);
            }
            
        });
    }

    public int[] someMethod(int[] arr, int k) {
        int sum = 0;
        int len = Integer.MIN_VALUE;
        int n = arr.length;
        int start = 0;
        int end = 0;

        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = i; j < n; j++) {
                if(sum % k == 0) {
                    if(len < j - i + 1) {
                        len = j - i + 1;
                        start = i;
                        end = j;
                    }
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        int[] result = new int[len];
        for(int i = start; i <= end; i++) {
            result[i] = arr[i];
        }
        return result;
    }

System.out.println("Minimum sum of maximum integers: " + minSum);
    }
    
}
