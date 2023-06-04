package Leetcode_Problems.FindTheHighestAltitude;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int[] arr = new int[gain.length + 1];
        int maxAltitude = 0;
        arr[0] = 0;
        for(int i = 1; i < arr.length; i++) {
            arr[i] = gain[i] - gain[i-1];
            maxAltitude = Math.max(arr[i], maxAltitude);
        }
        return maxAltitude;
    }
}
