class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor = image[sr][sc];
        if(oldColor != newColor) dfs(image, sr, sc, newColor, oldColor); //this line is very important..only call dfs if oldcolor != newcolor other wise it will throw stack overflow. 
        return image;
        
    }
    
    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor)
    {
        if(sr > image.length - 1 || sc > image[0].length - 1|| sr < 0|| sc < 0|| image[sr][sc] != oldColor)
        {
            return;
        }
        if(image[sr][sc] == oldColor)
        {
            image[sr][sc] = newColor;
            if(sr+1 < image.length) dfs(image, sr+1, sc, newColor, oldColor);
            if(sc+1 < image[0].length) dfs(image, sr, sc+1, newColor, oldColor);
            if(sr-1 >= 0) dfs(image, sr-1, sc, newColor, oldColor);
            if(sc-1 >= 0) dfs(image, sr, sc-1, newColor, oldColor);
        }
        
        
    }
}
