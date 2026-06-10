class Solution {
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m=image.length;
        n=image[0].length;
        int initialColor=image[sr][sc];
        if(initialColor!=color){
            dfs(image,sr,sc,color,initialColor);
        }
        return image;
    }
    public void dfs(int[][] image,int i,int j,int color,int initialColor){
        if(i<0 || j<0 || i>=m || j>=n || image[i][j]!=initialColor) return;
        image[i][j]=color;
        dfs(image,i+1,j,color,initialColor);
        dfs(image,i-1,j,color,initialColor);
        dfs(image,i,j+1,color,initialColor);
        dfs(image,i,j-1,color,initialColor);
    }

}