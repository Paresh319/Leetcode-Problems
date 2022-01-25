//best problem to understand bfs

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
        {
            return 0;
        }
    
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < wordList.size(); i++)
        {
            hs.add(wordList.get(i));
        }
        System.out.println(hs);
        
        
        int level = 1;
        Queue<String> q = new LinkedList<String>();
        
        q.offer(beginWord);
        hs.remove(beginWord);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int j = 0; j < size; j++)
            {
                String oldWord = q.poll();
                char[] old = oldWord.toCharArray();
                for(int i = 0; i < old.length; i++)
                {
                    char originalchar = old[i];
                    for(char c = 'a'; c < 'z'; c++)
                    {
                        if(old[i] == c) continue;
                        old[i] = c;
                        String newWord = String.valueOf(old);
                        if(newWord.equals(endWord))
                        {
                            return level+1;
                        }
                        if(hs.contains(newWord))
                        {
                            q.offer(newWord);
                            hs.remove(newWord);
                        }
                    }
                    old[i] = originalchar;
                }
            }
            
            level++;
        }
        
        return 0;
    }
        
}
    
