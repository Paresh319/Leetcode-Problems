package Leetcode_Problems.EvaluateDivision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Element
    {
        String a;
        Double b;
        public Element(String a, Double b)
        {
            this.a = a;
            this.b = b;
        }
    }

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Element>> hm = new HashMap<>();

        int i = 0;
        while(i < equations.size())
        {
            List<String> temp = equations.get(i);
            double temp1 = values[i];
            if(!hm.containsKey(temp.get(0)))
            {
                hm.put(temp.get(0), new ArrayList<Element>());
            }
            if(!hm.containsKey(temp.get(1)))
            {
                hm.put(temp.get(1), new ArrayList<Element>());
            }
            
            hm.get(temp.get(0)).add(new Element(temp.get(1), temp1));
            
            hm.get(temp.get(1)).add(new Element(temp.get(0), (1/temp1)));
            i++;
        }
        
        List<Double> output = new ArrayList<>();

        for(int j = 0; j < queries.size(); j++)
        {
           List<String> temp = queries.get(j);
            double res = 0.0;
            if(!hm.containsKey(temp.get(0)) || !hm.containsKey(temp.get(1)))
            {
                output.add(-1.0);
                continue;
            }
            if(temp.get(0).equals(temp.get(1)))
            {
                output.add(1.0);
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            res = dfs(hm, temp.get(0), temp.get(1), 1.0, visited);
            output.add(res);
        }
        double[] t = new double[output.size()];
        int k = 0;
        for(double o: output)
        {
            t[k++] = o;
        }
        
        return t;
    }
    public double dfs(HashMap<String, List<Element>> hm, String start, String end, double ans, HashSet<String> visited)
    {
        if(start.equals(end))
        {
            return 1.0;
        }
        
        double val = -1.0;
        List<Element> e = hm.get(start);
        
       
        for(Element m: e)
        {
            if(m.a.equals(end))
            {
                return m.b;
            }
            
            if(!visited.contains(m.a))
            {
                visited.add(start);
                val =  dfs(hm, m.a, end, ans, visited);
                if(val != -1)
                {
                    return val * m.b;
                }
            }
        }
        
        return -1;
    }
    
    
}