package Leetcode_Problems.PartitionLabels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;

class Element{
    int start;
    int end;
    boolean firstFound;
}

public class PartitionLables {


    public static List<Integer> partitionLabels(String s) {
        HashMap<Character, Element> hm = new LinkedHashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)).firstFound)
            {
                hm.get(s.charAt(i)).end = i;
            }
            else
            {
                Element e = new Element();
                e.start = i;
                e.end = i;
                e.firstFound = true;
                hm.put(s.charAt(i), e);
            }
        }
        List<Element> res = new ArrayList<Element>(hm.values());

        Comparator<Element> comp = new Comparator<Element>() {
            public int compare(Element e1, Element e2)
            {
                return e1.start - e2.start;
            }
            
        };
        
        Collections.sort(res, comp);
//         for (int i = 0; i < res.size(); i++) {
//              System.out.println(res.get(i).start+"--"+ res.get(i).end);
            
            
//         }

        PriorityQueue<Element> pq = new PriorityQueue<Element>((e1, e2) ->  e2.start  - e1.start);
        pq.add(res.get(0));
        
        for(int i = 1; i < res.size(); i++)
        {
            Element a = pq.peek();
            Element e = res.get(i);
            Element temp = new Element();
            
            // temp.end = a.end;
            if(e.start <= a.end)
            {
                temp.start = a.start;
                temp.end = Math.max(a.end, e.end);
                pq.poll();
                pq.add(temp);
                
            }
            else
            {
                pq.add(e);
            }
            // pq.add(temp);
        }
         System.out.println("size of pq--"+ pq.size() );

        List<Integer> ret = new ArrayList<>();
        while(!pq.isEmpty())
        {
           
            Element e = pq.poll();
            
            ret.add(e.end - e.start + 1);
        }
        List<Integer> l = new ArrayList<>();
        for(int i = ret.size() - 1; i >=0 ; i++)
        {
            l.add(ret.get(i));

        }

        return l;
        
        
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        List<Integer> l = partitionLabels(s);
    }

    
}
