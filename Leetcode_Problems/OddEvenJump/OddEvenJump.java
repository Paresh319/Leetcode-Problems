package Leetcode_Problems.OddEvenJump;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//Important question 
/*
 * concepts covered - Monotonic stack, next greater least element, next smaller greatest element and
 * dp. Related to next greater element and jump game
 * 
 */

public class OddEvenJump {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        Integer[] odd = new Integer[n];
        Integer[] even = new Integer[n];
        for(int i = 0; i < n; i++)
        {
            odd[i] = i;
            even[i] = i;
        }
        Arrays.sort(odd, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return arr[o1] - arr[o2];
            }
        });

        Arrays.sort(odd, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return arr[o2] - arr[o1];
            }
        });

        int[] evenInput = new int[n];
        int[] oddInput = new int[n];
        

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < arr.length; i++)
        {
            while(!stk.isEmpty() && stk.peek() < even[i])
            {
                evenInput[stk.pop()] = arr[i];
            }
            stk.push(arr[i]);
        }


        for(int i = 0; i < arr.length; i++)
        {
            while(!stk.isEmpty() && stk.peek() < odd[i])
            {
                oddInput[stk.pop()] = arr[i];
            }
            stk.push(arr[i]);
        }

       


    }
}