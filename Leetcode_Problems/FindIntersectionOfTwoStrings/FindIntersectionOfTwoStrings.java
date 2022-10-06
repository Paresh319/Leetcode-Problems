package Leetcode_Problems.FindIntersectionOfTwoStrings;

import java.util.HashSet;

public class FindIntersectionOfTwoStrings {
    public static String FindIntersection(String[] strArr) {
        String[] a1 = strArr[0].split(",");
        String[] a2 = strArr[1].split(",");
    
        HashSet<String> hs = new HashSet<>();
        for(String s: a1){
    
          hs.add(s);
        }
        String res = "";
        for(String p: a2){
          if(hs.contains(p)){
            res += p;
            res += ",";
          }
        }
        res = res.replaceAll("\\s", "");
        return res.substring(0, res.length() - 1);
    
}
}
