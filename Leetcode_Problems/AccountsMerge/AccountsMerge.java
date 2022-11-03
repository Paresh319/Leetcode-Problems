package Leetcode_Problems.AccountsMerge;

import java.security.cert.CertPathValidatorException.Reason;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AccountsMerge {
    HashMap<String, List<String>> hm = new HashMap<>();
    HashMap<String, String> names = new HashMap<>();
    HashSet<String> hs = new HashSet<>();
    HashSet<String> visited = new HashSet<>();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Mapping the emails to name
        for(List<String> l: accounts) {
            String a = l.get(0);
            String b = l.get(1);
            String[] c = b.split(",");
            for(int i = 0; i < c.length; i++) {
                names.put(c[i], a);
            }
        }
        
        //Creating a map for connecting emails.
        for(List<String> l : accounts) {
            for(int i = 1; i < l.size(); i++) {
                String a = l.get(i);
                if(!hm.containsKey(a)) {
                    hm.put(a, new ArrayList<String>());
                }
                for(int j = 1; j < l.size(); j++) {
                    if(i == j) {
                        continue;
                    }
                    hm.get(a).add(l.get(j));
                }
            }
        }
        
        
        List<List<String>> result = new ArrayList<>();
        
        //dfs traversal on every node so that we get all accounts for one name
          for(String p: names.keySet()) {
            List<String> res = new ArrayList<>();
            if(!visited.contains(p)) {
                dfs(p, res);
                List<String> res1 = new ArrayList<>();
                res1.add(names.get(p));
                Collections.sort(res);
                res1.addAll(res);
                result.add(new ArrayList<>(res1));
            }
        }
        return result;
    }

    public void dfs(String p, List<String> res) {
        if(visited.contains(p)) {
            return;
        }
        visited.add(p);
        res.add(p);
        for(String l: hm.get(p)) {
            dfs(l, res);
        }
    }
    
}