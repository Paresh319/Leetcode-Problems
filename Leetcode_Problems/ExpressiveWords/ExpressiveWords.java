package Leetcode_Problems.ExpressiveWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {

        List<List<Integer>> l1 = new ArrayList<>();
        List<List<Integer>> l2 = new ArrayList<>();

        int i = 0;
        int res = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while(i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.valueOf(c));
            temp.add(count);
            l1.add(temp);
        }

        for(String w: words) {
            int j = 0;
            l2 = new ArrayList<>();
            while(j < w.length()) {
                char c = w.charAt(j);
                int count = 0;
                while(j < w.length() && w.charAt(j) == c) {
                    count++;
                    j++;
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(Integer.valueOf(c));
                temp.add(count);
                l2.add(temp);
            }
            if(l1.size() != l2.size()) {
                continue;
            }
            boolean flag = true;
            for(int k = 0; k < l2.size(); k++) {
                List<Integer> l3 = l1.get(k);
                List<Integer> l4 = l2.get(k);
                if(l3.get(0) != l4.get(0)) {
                    flag = false;
                    break;
                }
                else {
                    if(l3.get(1) != l4.get(1)){
                        if(l3.get(1) < l4.get(1) || l3.get(1) < 3) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag) {
                res++;
            }
        }
        return res;
    }
}
