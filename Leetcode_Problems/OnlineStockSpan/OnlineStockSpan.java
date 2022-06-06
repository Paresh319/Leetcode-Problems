package Leetcode_Problems.OnlineStockSpan;

import java.util.Stack;

class Element{
    int data;
    int sno;
}
   public class OnlineStockSpan {
    Stack<Element> stk = new Stack<>();
    int count = 1;
    int sno = -1;

    public OnlineStockSpan() {
        
    }
    
    public int next(int price) {
        sno++;
        if(stk.isEmpty())
        {
            Element e = new Element();
            e.data = price;
            e.sno = sno;
            stk.push(e);
            return 1;
        }
        else
        {
            // int count = 1;
            while(!stk.isEmpty() && price >= stk.peek().data)
            {
                // count++;
                stk.pop();
            }
            int returnValue = 0;
            if(stk.isEmpty())
            {
                 Element e1 = new Element();
                e1.data = price;
                e1.sno = sno;
                stk.push(e1);
                return sno + 1;
            }
            else 
            {
                returnValue = sno - stk.peek().sno;
                Element e1 = new Element();
                e1.data = price;
                e1.sno = sno;
                stk.push(e1);
                
                return returnValue;
                
            }
            
            // return returnValue;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
