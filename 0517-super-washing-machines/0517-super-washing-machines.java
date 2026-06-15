class Solution {
    public int findMinMoves(int[] m) {
        int t = 0; 
        for (int w : m) {
            t += w;
        }
        int n = m.length;
        if (t % n != 0) {
            return -1;
        }
        int a = t / n; 
        int r = 0;     
        int c = 0;     
        
        for (int w : m) {
            int d = w - a; 
            c += d;
            r = Math.max(r, Math.max(Math.abs(c), d));
        }
        
        return r;
    }
}