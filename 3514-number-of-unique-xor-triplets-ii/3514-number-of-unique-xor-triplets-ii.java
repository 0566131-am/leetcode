class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        boolean[] seenPairs = new boolean[2048];
        boolean[] seenTriplets = new boolean[2048];

        for (int k = 0; k < n; k++) {
            // 1. Add all pairs (i, k) for 0 <= i <= k
            for (int i = 0; i <= k; i++) {
                seenPairs[nums[i] ^ nums[k]] = true;
            }

            // 2. Combine all existing pair XORs with nums[k]
            for (int x = 0; x < 2048; x++) {
                if (seenPairs[x]) {
                    seenTriplets[x ^ nums[k]] = true;
                }
            }
        }

        // 3. Count unique triplet XOR results
        int count = 0;
        for (boolean present : seenTriplets) {
            if (present) {
                count++;
            }
        }

        return count;
    }
}