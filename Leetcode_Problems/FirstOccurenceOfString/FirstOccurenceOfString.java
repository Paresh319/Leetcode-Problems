class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        int segmentsize = needle.length();
        int res = -1;
        
        for(int i = 0 ; i <= haystack.length() - segmentsize; i++)
        {
            // System.out.println(haystack.substring(i, i+segmentsize));
            if(haystack.substring(i, i+segmentsize).equals(needle))
            {
                res = i;
                break;
            }
        }
        return res;
        
    }
}
