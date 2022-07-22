package Leetcode_Problems.SparseMatrix;

public class Pair<T1, T2> {
    int key;
    int value;

    Pair(int a, int b)
    {
        key = a;
        value = b;
    }

    public int getKey()
    {
        return key;
    }

    public int getValue()
    {
        return value;
    }
}