/*
Add a checked array along with visited 
Because after we have seen through one dfs that none of the children node have any cycles then they do not need to be checked again 
since from any node they wont be having any cycles. This is an important part here because without this the solution will give TLE.
*/
class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        for(int[] relation: prerequisites)
        {
            if (hm.containsKey(relation[1])) {
                hm.get(relation[1]).add(relation[0]);
              } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                hm.put(relation[1], nextCourses);
              }
        }
        
        boolean[] checked = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
           if(dfs(hm, visited, i, checked))
               return false;
        }
        return true;
    }
    
    public boolean dfs(HashMap<Integer, List<Integer>> hm, boolean[] visited, int start, boolean[] checked)
    {
        
        if(visited[start])
        {
            return true;
        }
        if(checked[start])
        {
            return false;
        }
        
        if(!hm.containsKey(start))
        {
            return false;
        }
        
        visited[start] = true;
        
        boolean o = false;
        for(Integer l: hm.get(start))
        {
            if(dfs(hm, visited, l, checked))
                    return true;
        }
        
        visited[start] = false;
        checked[start] = true;
        return false;
    }
}

