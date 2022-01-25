/*
3. Longest Substring Without Repeating Characters -

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
*/
/*
Approach-
Generate a hashset.
loop over every character,check if character exists in hashmap, if yes remove
if not add.
compare with max, if greater than max, set max. Finally return max
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0; 
        int  j = 0;
        int max = 0;//Integer.MIN_VALUE;
        HashSet<Character> hm = new HashSet<Character>();
        while(i < s.length()) 
        {
            if(!hm.contains(s.charAt(i)))
            {
                hm.add(s.charAt(i));
                if(max < hm.size())
                {
                    max = hm.size();
                }
                i++;
            }
            else{
                hm.remove(s.charAt(j++));
            }
        }
        return max;
        
}
}
/*
Runtime: 6 ms, faster than 61.25% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 39.4 MB, less than 37.39% of Java online submissions for Longest Substring Without Repeating Characters.
*/