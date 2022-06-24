package Leetcode_Problems.FruitsIntoBaskets;

import java.util.ArrayDeque;
import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

public class FruitsIntoBAskets {

    public int totalFruit(int[] fruits) {
       HashMap<Integer, Integer> hm = new HashMap<>();

       int i = 0;
       int j =0;
       int count = 0;
       int res = 0;

       while(j < fruits.length)
       {
           hm.put(fruits[i], hm.getOrDefault(fruits[i], 0) + 1);

           while(hm.size() > 2)
           {
               hm.put(fruits[i], hm.get(fruits[i]) - 1);
               if(hm.get(fruits[i]) == 0)
               {
                   hm.remove(fruits[i]);

               }
               i++;
           }
           res = Math.max(res, j - i + 1);
           
       }
       return res;
       
        
    }
    
}
