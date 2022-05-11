package Leetcode_Problems.BEstTimeToBuyAndSellStock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {
        int minPrice = 0;
        int maxPrice = 0;

        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < minPrice)
            {
                minPrice = prices[i];
            }
            else if(prices[i] > maxPrice)
            {
                maxPrice = prices[i];
            }
        }
        // System.out.println(maxPrice);
        // System.out.println(minPrice);
        return maxPrice - minPrice;
        
        
    }
   

   


    public static void main(String[] args) {
        int[] t = {7,1,5,3,6,4};
        System.out.println(maxProfit(t));
    }

    
}
