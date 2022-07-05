package Leetcode_Problems.BrokenCalculator;

import javax.xml.stream.events.StartDocument;

public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while(target > startValue)
        {
            res++;
            if(target % 2 == 0)
            {
                target/=2;
                
            }
            else
                target++;
        }
        return res + startValue - target;
    }

    public int dfs(int startValue, int target, int count)
    {
        if(target <= startValue)
        {
            return startValue - target;
        }
        if(target % 2 == 0)
        {
            return 1+ dfs(startValue, target/2, count);
        }
        else
        {
            return 1 + dfs(startValue, target+1,  count);
        }

    }
    
}
