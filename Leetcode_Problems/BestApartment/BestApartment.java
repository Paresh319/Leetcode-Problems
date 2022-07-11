package Leetcode_Problems.BestApartment;

import java.util.List;

class DLinkedList
{
     Node head;
     Node tail;


}

class Node
{
    Node next;
    Node prev;
    boolean[] values;
    int n ;
    int[] dist;
    Node()
    {

    }
    Node(boolean[] val)
    {
        values = val;
        n = val.length;
        dist = new int[n];
        for(int i = 0; i < n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
    }
}


public class BestApartment {
    public int bestApartment(List<boolean[]> distances)
    {
        Node head = new Node();
        int i = 0;
        Node curr = head;
        while(i < distances.size())
        {
            curr = new Node(distances.get(i));
            curr = curr.next;
        }

        i = 0;
        for( i = 0; i < head.dist.length; i++)
        {
            if(head.values[i] == true)
            {
                head.dist[i] = 0;
            }
        }
        


    }
}
