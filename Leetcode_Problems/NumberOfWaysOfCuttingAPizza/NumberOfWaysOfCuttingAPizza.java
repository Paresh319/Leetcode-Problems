package Leetcode_Problems.NumberOfWaysOfCuttingAPizza;

public class NumberOfWaysOfCuttingAPizza {
    int count = 0;
    public int ways(String[] pizza, int k) {
        recursiveHelper(0, pizza);
        return count;
    }

    public void recursiveHelper(int start, String[] pizza) {
        if(pizza.length == 0) {
            count++;
            return;
        }
        String a = pizza[start];
        if(a.contains("A")) {
            recursiveHelper(1, pizza);
        }

        String b = "";
        for(int i = start; i < pizza.length; i++) {
            b += pizza[i].charAt(0);
            pizza[i] = pizza[i].substring(1);
        }
        if(b.contains("A")) {
            recursiveHelper(start, pizza);
        }
    }
}