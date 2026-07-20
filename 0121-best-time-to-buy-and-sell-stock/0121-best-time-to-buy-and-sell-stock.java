class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int p=0;
        for(int i=1;i<prices.length;i++){
            int c=prices[i]-mini;
             p=Math.max(p,c);
          mini=Math.min(prices[i],mini);
        
        }
        return p;
         
    }
}