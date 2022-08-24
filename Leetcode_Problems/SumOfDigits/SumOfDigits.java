package Leetcode_Problems.SumOfDigits;

public class SumOfDigits {
    public int addDigits(int num) {
        int sum = num;
        while(sum > 9)
        {
            sum = addD(sum);
        }
        return sum;
    }
    
    public int addD(int sum)
    {
        int res= 0;
        while(sum > 0)
        {
            res += sum % 10;
            sum /= 10;
        }
        return res;
    }
}
