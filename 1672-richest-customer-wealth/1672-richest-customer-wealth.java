class Solution {
    public int maximumWealth(int[][] accounts) {
         int maxx=0;
        int rows=accounts.length;
        int cols=accounts[0].length;
        for(int i=0;i<rows;i++){
           int  c=0;
            for(int j=0;j<cols;j++){
             c=c+accounts[i][j];
            }

           maxx=Math.max(c,maxx);
        }
        return maxx;



        
    }
}