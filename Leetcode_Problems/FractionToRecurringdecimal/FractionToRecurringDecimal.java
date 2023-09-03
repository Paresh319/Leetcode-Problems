package Leetcode_Problems.FractionToRecurringdecimal;

import java.util.HashMap;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        res.append(sign);
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        res.append(num/den);
        long rem = num % den;
        if(rem == 0) {
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> hm = new HashMap<>();
        while(rem != 0) {
            rem *= 10;
            res.append(rem /den);
            rem %= den;
            if(hm.containsKey(rem)) {
                int index = hm.get(rem);
                res.insert(index, "(");
                res.append(")");break;
            }
            else {
                hm.put(rem, res.length());
            }
            
        }
        return res.toString();
    }
}
