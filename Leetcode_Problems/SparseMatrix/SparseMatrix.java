package Leetcode_Problems.SparseMatrix;

import java.util.ArrayList;


public class SparseMatrix {
    ArrayList<ArrayList<Pair<Integer, Integer>>> res;
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> A = createList(mat1);
        ArrayList<ArrayList<Pair<Integer, Integer>>> B = createList(mat2);
        int[][] ans = new int[mat1.length][mat2[0].length];
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        for (int mat1Row = 0; mat1Row < m; ++mat1Row) {
            for (Pair mat1Element : A.get(mat1Row)) {
                int element1 = (int)mat1Element.getKey();
                int mat1Col = (int)mat1Element.getValue();

                for (Pair mat2Element : B.get(mat1Col)) {
                    int element2 = (int)mat2Element.getKey();
                    int mat2Col = (int)mat2Element.getValue();                 
                    ans[mat1Row][mat2Col] += element1 * element2;
                }
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Pair<Integer, Integer>>> createList(int[][] matrix)
    {
        ArrayList<ArrayList<Pair<Integer, Integer>>> compressedMatrix = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Pair> l = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0)
                {
                    l.add(new Pair<>(matrix[i][j], j));
                }
            }
            compressedMatrix.add(new ArrayList<>(l));
        }
        return compressedMatrix;
    }
}
