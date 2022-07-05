package Leetcode_Problems.WordSquares;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
    List<List<String>> res = new ArrayList<>();
    int k = 0;
    public List<List<String>> wordSquares(String[] words) {
        k = words[0].length();
        for(int i = 0; i < words.length; i++)
        {
            recursiveHelper(words, i, new ArrayList<String>(), )
        }
    }
    public void recursiveHelper(String[] words, int i, ArrayList<String> l)
    {
        if(i >= l.size())
        {
            return;
        }
        if(k == l.size())
        {
            res.add(new ArrayList<String>(l));
        }
        l.add(words[i]);
        for(int j = i + 1; j < words.length; j++)
        {
            recursiveHelper(words, j, l);
        }
    }
}
