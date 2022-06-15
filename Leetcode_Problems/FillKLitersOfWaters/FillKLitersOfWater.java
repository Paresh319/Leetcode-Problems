package Leetcode_Problems.FillKLitersOfWaters;

public class FillKLitersOfWater {

    int count = 0;
    public static int fillWater(int n, int k)
    {
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++)
        {
            arr[i] = i+1;
        }
        return backtrack(arr, k, new int[k]);
    }

    public static int backtrack(int[] coins, int rem, int[] count)
    {
        if(rem < 0)
            return -1;
        if(rem == 0)
        {
            return 0;
        }
        if(count[rem - 1] != 0)
            return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for(int coin: coins)
        {
            int res = backtrack(coins, rem - coin, count);
            if(res >= 0 && res < min)
            {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
    }

    public static void main(String[] args) {
        System.out.println(fillWater(1, 2));
    }
}
