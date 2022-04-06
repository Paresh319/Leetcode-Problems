//hard question because we are using a double ended queue and traversing each element of the array
// we check if the last element of the queue is smaller than the current if yes then pop it. 
// then we check if the left is greater than the first element in the queue 
// if yes then pop it.
// then we check if the right pointer is atleast k if yes then we add the first element and increment left pointer;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        List<Integer> output = new ArrayList<>();
    int n = nums.length;
        while(right < n)
        {
            while(!arrayDeque.isEmpty() && nums[right] > nums[arrayDeque.peekLast()])
            {
                arrayDeque.pollLast();
            }
            arrayDeque.addLast(right);
            if(left > arrayDeque.getFirst())
            {
                arrayDeque.pollFirst();
            }
            if(right + 1 >= k)
            {
                output.add(nums[arrayDeque.peekFirst()]);
                left++;
            }
            right++;
        }
        int[] result = new int[output.size()];
        for(int i = 0 ; i < result.length; i++)
        {
            result[i] = output.get(i);
        }
        return result;
        
    }
}
