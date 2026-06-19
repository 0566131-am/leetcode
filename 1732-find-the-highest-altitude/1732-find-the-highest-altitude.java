class Solution {
    public int largestAltitude(int[] gain) {
        int maxx=0;
        int cur=0;
        for(int i=0;i<gain.length;i++){
            cur=cur+gain[i];
            maxx=Math.max(maxx,cur);
        }
        return maxx;
    }
}