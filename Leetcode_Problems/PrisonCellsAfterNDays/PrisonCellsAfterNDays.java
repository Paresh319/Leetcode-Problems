package Leetcode_Problems.PrisonCellsAfterNDays;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(cells==null || cells.length==0 || n<=0) return cells;
        HashSet<String> hs = new HashSet<String>();
        boolean hasCycle = false;
        int cycle = 0;
        int[] res = cells;
        for(int i = 0; i < n; i++)
        {
            int[] next = transform(cells);
            String a = Arrays.toString(next);
            if(!hs.contains(a))
            {
                hs.add(a);
                cycle++;
            }
            else
            {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle)
        {
            n = n % cycle;
            for(int i = 0; i < n; i++)
            {
                cells = transform(cells);
            }
        }
        return cells;
    }
    
    public int[] transform(int[] res)
    {
        int[] temp = new int[res.length];
        for(int i = 1; i < res.length - 1; i++)
        {
            if(res[i - 1] == res[i + 1])
            {
                temp[i] = 1;
            }
            else
            {
                temp[i] = 0;
            }
        }
        return temp;
    }
    
}
