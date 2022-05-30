package Leetcode_Problems.SearchInA2DMatrix;

public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int left = 0;
        int right = matrix.length - 1;
        int rowNum = 0;

        while(left < right)
        {
            int mid = (left + right)/ 2;
            rowNum = mid;
            if(matrix[mid][0] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        left = 0;
        right = matrix[0].length;
        while(left < right)
        {
            int mid = (left + right)/ 2;
            if(matrix[rowNum][mid] == target)
            {
                return true;
            }
            if(matrix[rowNum][mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return false;


        
        
    }
    
}
