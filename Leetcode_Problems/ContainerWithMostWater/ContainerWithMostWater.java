class Solution {
    public int maxArea(int[] height) {
        
        int i =0; int j = height.length -1;
        int volume = 0;
        while(i<j)
        {
             volume = Math.max(Math.min(height[i], height[j]) * (j-i), volume);
            
            if(height[i] < height[j])
            {
                i++;
                
            }
            else
            {
                j--;
            }
            
            
        }
        return volume;
        
    }
}
