package Leetcode_Problems.MultiplyStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        List<List<Integer>> ap = new ArrayList<>();
        int m = num1.length();
        int n = num2.length();
        int carry = 0;
        int maxLength = 0;
        int zeroes = 0;

        for(int i = m-1; i >= 0; i--) {
            ArrayDeque<Integer> l = new ArrayDeque<>();
            for(int q = 0; q < zeroes; q++) {
                l.addFirst(0);
            }
            zeroes++;
            for (int j = n-1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int c = a * b;
                c += carry;
                if(c > 9) {
                    carry = c / 10;
                }
                else {
                    carry = 0;
                }
                l.addFirst(c % 10);
            }
            if(carry > 0) {
                l.addFirst(carry);
                carry = 0;
            }
            ap.add(new ArrayList<>(l));
            maxLength = Math.max(maxLength, l.size());
        }
        int k = maxLength;
        for(int i= 0; i < ap.size(); i++) {
            int sum = 0;
            int temp = 0;
            if(k < ap.get(i).size()) {
                sum += ap.get(i).get(k);
            }
        }
    }
    
}
