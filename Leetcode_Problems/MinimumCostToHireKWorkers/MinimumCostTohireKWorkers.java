package Leetcode_Problems.MinimumCostToHireKWorkers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostTohireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double captainsRatio = 0;
        double minSum = Double.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            captainsRatio = wage[i] / quality[i];
            List<Double> l = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                double offerJ = quality[j] * captainsRatio;
                if(offerJ < wage[j]) {
                    continue;
                }
                l.add(offerJ);
            }
            if(l.size() < k) {
                continue;
            }
            PriorityQueue<Double> pq = new PriorityQueue<>();
            double sum = 0.0;
            for(double p: l) {
                pq.add(p);
                sum += p;
                if(pq.size() > k) {
                    sum -= pq.poll();
                }
            }
            minSum = Math.min(minSum, sum);
        }
        return minSum;

        
    }
}
