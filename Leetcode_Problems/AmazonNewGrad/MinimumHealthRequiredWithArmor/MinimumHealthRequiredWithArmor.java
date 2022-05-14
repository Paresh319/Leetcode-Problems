package Leetcode_Problems.AmazonNewGrad.MinimumHealthRequiredWithArmor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinimumHealthRequiredWithArmor {
    public static int minimumHealth(List<Integer> power, int armor)
        {
            int sum = 0;
            for(int i: power)
            {
                sum+= i;
            }
            int result = sum - Math.min(armor, Collections.max(power)) + 1;
            return result;
            
        }
    
        public static void main(String[] args) {
            // int[] test = {1,2,6,7};
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            l.add(6);
            l.add(7);
            System.out.println(minimumHealth(l, 5));
        }
    
}
