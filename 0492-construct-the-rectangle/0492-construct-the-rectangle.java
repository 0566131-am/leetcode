class Solution {
    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);
        while (W > 0) {
            if (area % W == 0) {
                int L = area / W;
                return new int[]{L, W};
            }
            W--;
        }
        // Fallback (should never reach here for positive area)
        return new int[]{area, 1};
    }
}