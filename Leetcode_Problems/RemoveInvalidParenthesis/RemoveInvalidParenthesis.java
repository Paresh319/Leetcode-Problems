package Leetcode_Problems.RemoveInvalidParenthesis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.sound.midi.Soundbank;

public class RemoveInvalidParenthesis {
    List<String> res = new ArrayList<>();
    HashSet<Character> hs = new HashSet<Character>();
    PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
        public int compare(String a, String b)
        {
            return b.length() - a.length();
        }
    });
    
    public List<String> removeInvalidParentheses(String s) {
        hs.add('(');
        hs.add(')');
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i< s.length()){
            sb.append(s.charAt(i++));
        }

        backtrack(sb);
        int len = pq.peek().length();
        while(!pq.isEmpty() )
        {
            if(pq.peek().length() == len && !res.contains(pq.peek()))
            {
                res.add(pq.peek());
            }
            pq.poll();
            
        }
        return res;
    }

    public void backtrack(StringBuilder sb)
    {
        if(isValid(sb.toString()))
        {
            pq.offer(sb.toString());
            return;
        }
        for(int i = 0; i < sb.length(); i++)
        {
            if(!hs.contains(sb.charAt(i)))
            {
                continue;
            }
            String temp = sb.toString();
            sb.deleteCharAt(i);
            backtrack(sb);
            sb = new StringBuilder(temp);
        }
    }
    
    public boolean isValid(String temp){
        HashMap<Character, Character> hm = new HashMap();
        hm.put(')', '(');
        int i = 0;
        Stack<Character> stk = new Stack();
        String s = "";
        int k = 0;
        while(k < temp.length())
        {
            if(!hs.contains(temp.charAt(k)))
            {
                k++;
                continue;
            }
            s += temp.charAt(k++);
        }
        while(i < s.length())
        {
            char c = s.charAt(i);
            if(hm.containsKey(c))
            {
                if(stk.isEmpty() || stk.pop() != hm.get(c))
                {
                    return false;
                }
                
            }
            else 
            {
                stk.push(c);
            }
            i++;
        }
        if(stk.isEmpty())
        {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        RemoveInvalidParenthesis r = new RemoveInvalidParenthesis();
        List<String> result = r.removeInvalidParentheses("))(p(((())");
        System.out.println("hi");
        // System.out.println(r.removeInvalidParentheses("))(p(((())"));
    }
}
