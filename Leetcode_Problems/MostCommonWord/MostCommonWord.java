class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");
        String[] par = paragraph.split(" ");
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String l : par)
        { 
            if(l.equals(""))
            {
                continue;
            }

            l = l.toLowerCase();
            if(hm.containsKey(l))
            {
                hm.put(l, hm.get(l)+1);
            }
            else
            {
                hm.put(l, 1);
            }
        }
        
        for(String j: banned)
        {
            
            j = j.toLowerCase();
            if(hm.containsKey(j))
            {
                hm.remove(j);
            }
            
        }
        
        int max = Integer.MIN_VALUE;
            String res = "";
        for(String h : hm.keySet())
        {
            // if(h.equals(""))
            // {
            //     continue;
            // }
            System.out.println(h+" --  "+ hm.get(h));
            if(max < hm.get(h))
            {
                res = h;
                max = hm.get(h);
            }
        }
        return res;
        
    }
}
