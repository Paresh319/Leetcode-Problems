class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
           if (i == 0 || nums[i - 1] != nums[i]) 
           {
                int d = nums[i];
                int k = i+1;
                int j = nums.length -1;
                while(k<j)
                {
                    int sum = nums[i] + nums[k] + nums[j];
                  
                    if(sum < 0)
                    {
                        k++;
                    }
                    else if(sum > 0)
                    {
                        j--;
                    }
                    else
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);

                        res.add(new ArrayList<Integer>(l));
                        k++;
                        j--;
                        while (k < j && nums[k] == nums[k - 1])  //this line is important u need to skip all the duplicate elements.
                        ++k;
                    }
                }
            }
           }
        return res;    
    }
}
