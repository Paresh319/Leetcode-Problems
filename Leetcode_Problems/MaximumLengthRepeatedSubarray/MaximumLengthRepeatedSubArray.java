class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        int length = 0;
        int maxlength = 0;
        int ans= 0;
        for(int i = 0; i < nums1.length; i++)
        {
            for(int j = 0; j < nums2.length; j++)
            {
                int k = 0;
                while(i + k < nums1.length && j + k < nums2.length && nums1[i + k] == nums2[j + k])
                {
                    k+=1;
                }
                ans = Math.max(ans, k);
            }
        }
        return ans;
        
    }
}
