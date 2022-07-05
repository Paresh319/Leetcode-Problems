package Leetcode_Problems.CAndy;

public class Candy {
    public int candy(int[] ratings) {
        int positionOfMinimumElement = 0;

        for(int i = 0 ; i < ratings.length; i++)
        {
            if(ratings[positionOfMinimumElement] < ratings[i])
            {
                positionOfMinimumElement = i;
            }

        }
        int[] candies = new int[ratings.length];
        // int a = ratings[positionOfMinimumElement] == 0 ? 1: ratings[positionOfMinimumElement];
        candies[positionOfMinimumElement] = 1;

        for(int i = positionOfMinimumElement + 1; i < ratings.length; i++)
        {
            if(ratings[i] == ratings[i-1])
            {
                candies[i] = ratings[i];
            }
            else
            {
                candies[i] = ratings[i] + 1;
            }
        }

        for(int i = positionOfMinimumElement - 1; i >=0; i++)
        {
            if(ratings[i] == ratings[i+1])
            {
                candies[i] = ratings[i];
            }
            else
            {
                candies[i] = ratings[i + 1] + 1;
            }
        }
        int sum = 0;
        for(int i: candies)
        {
            sum+=i;
        }
        return sum;


        
    }
    
}
