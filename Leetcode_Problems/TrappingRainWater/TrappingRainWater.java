class Solution {
    public int trap(int[] height) {
        int sum = 0;
        for(int i  = 1; i < height.length; i++)
        {
            int lMax = height[i];
            int rMax = height[i];
            
            for(int j = 0 ; j < i; j++)
            {
                lMax = Math.max(height[j], lMax);
            }
            for(int j = i+1 ; j < height.length; j++)
            {
                rMax = Math.max(height[j], rMax);
            }
            int temp = Math.min(rMax, lMax) - height[i];
            sum += temp;
        }
        return sum;
        
    }
}
