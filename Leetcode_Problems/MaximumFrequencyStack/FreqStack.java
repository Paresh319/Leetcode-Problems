package Leetcode_Problems.MaximumFrequencyStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Element {
    int val; 
    int freq;
    int position;
    public Element(int a, int b, int c)
    {
        val = a;
        freq = b;
        position = c;
    }
}
class MyComparator implements Comparator<Element>{
    public int compare(Element a, Element b) {
                if(a.freq == b.freq)
                {
                    return b.position - a.position;
                }
                return b.freq - a.freq;
            }
    
}
class FreqStack {
    
    PriorityQueue<Element> l;
    int k = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();

    public FreqStack() {
        l = new PriorityQueue<Element>(new MyComparator());
    }
    
    public void push(int val) {
        if(hm.containsKey(val))
        {
            int newFreq = hm.get(val) + 1;
            hm.put(val, newFreq);
            Element temp = new Element(val, newFreq, k++);
            l.add(temp);
        }
        else
        {
            hm.put(val, 1);
            Element temp = new Element(val, 1, k++);
            l.add(temp);
        }
    }
    
    public int pop() {
        int ret = l.poll().val;
        int newFreq = hm.get(ret) - 1;
        hm.put(ret, newFreq);
        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */