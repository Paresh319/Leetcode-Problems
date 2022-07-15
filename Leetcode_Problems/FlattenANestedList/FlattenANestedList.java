package Leetcode_Problems.FlattenANestedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    List<Integer> res = new ArrayList<>();
    int pos = 0;
    
    public void recursiveHelper(List<NestedInteger> l)
    {
        for(int j = 0; j < l.size(); j++)
        {
            if(l.get(j).isInteger())
            {
                int q = l.get(j).getInteger();
                res.add(q);
            }
            else
            {
                recursiveHelper(l.get(j).getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        recursiveHelper(nestedList);
    }

    @Override
    public Integer next() {
        int temp = 0;
        if(!hasNext())
        {
            throw new NoSuchElementException();
            
            
        }
        temp = res.get(pos);
        pos++;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return pos < res.size();
      
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */