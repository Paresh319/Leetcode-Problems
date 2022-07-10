package Leetcode_Problems.WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder2 {
    HashMap<String, List<String>> hm = new HashMap<>();

    public List<String> findNeighbors(String beginWord, HashSet<String> hs)
    {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < beginWord.length(); i++)
            {
                char[] wordArr = beginWord.toCharArray();
                char oldChar = beginWord.charAt(i);
                for(char c = 'a'; c <'z'; c++)
                {
                    if(c == oldChar)
                    {
                        continue;
                    }
                    wordArr[i] = c;
                    String newWord = String.valueOf(wordArr);
                    if(hs.contains(newWord))
                    {
                        res.add(newWord);
                    }
                }
            }
            return res;
    }

    public void bfs(String beginWord, String endWord, HashSet<String> hs)
    {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        hs.remove(beginWord);

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-- > 0)
            {
                String temp = q.poll();
                List<String> neighbors = findNeighbors(temp, hs);

                if(!hm.containsKey(temp))
                {
                    hm.put(temp, new ArrayList<String>());
                }
                for(String w: neighbors)
                {
                    hm.get(temp).add(w);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        HashSet<String> hs = new HashSet<>(wordList);
        bfs(beginWord, endWord, hs);
    }

    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     HashMap<String, List<String>> hm = new HashMap<>();

    //     HashSet<String> hs = new HashSet<>(wordList);

    //     for(String word: wordList)
    //     {
    //         hm.put(word, new ArrayList<String>());
    //     }
        

    //     for(String word: wordList)
    //     {
    //         for(int i = 0; i < word.length(); i++)
    //         {
    //             char[] wordArr = word.toCharArray();
    //             char oldChar = word.charAt(i);
    //             for(char c = 'a'; c <'z'; c++)
    //             {
    //                 if(c == oldChar)
    //                 {
    //                     continue;
    //                 }
    //                 wordArr[i] = c;
    //                 String newWord = String.valueOf(wordArr);
    //                 if(hs.contains(newWord))
    //                 {
    //                     hm.get(word).add(newWord);
    //                 }
    //             }
    //         }
    //     }
    //     if(!hm.containsKey(beginWord))
    //     {
    //         for(int i = 0; i < beginWord.length(); i++)
    //         {
    //             char[] wordArr = beginWord.toCharArray();
    //             char oldChar = beginWord.charAt(i);
    //             for(char c = 'a'; c <'z'; c++)
    //             {
    //                 if(c == oldChar)
    //                 {
    //                     continue;
    //                 }
    //                 wordArr[i] = c;
    //                 String newWord = String.valueOf(wordArr);
    //                 if(hs.contains(newWord))
    //                 {
    //                     hm.get(beginWord).add(newWord);
    //                 }
    //             }
    //         }

    //     }

    //     dfs(beginWord, endWord, hm, new HashSet<String>(), new ArrayList<String>());

    //     return res;


    // }
    // public void dfs(String beginWord, String endWord, HashMap<String, List<String>> hm, HashSet<String> seen, ArrayList<String> l)
    // {
    //     if(beginWord.equals(endWord))
    //     {
    //         l.add(endWord);
    //         res.add(new ArrayList<>(l));
    //         return;
    //     }
    //     seen.add(beginWord);
    //     for(String a: hm.get(beginWord))
    //     {
    //         if(!seen.contains(a))
    //         {
    //             dfs(a, endWord, hm, seen, l);
                    // hs.remove(a);
                    // l.remove(l.size() - 1);

    //         }
    //     }


    // }
    


    
}
