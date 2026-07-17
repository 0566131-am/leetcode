class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Step 1: Count frequency of each number
        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }
        
        // Step 2 & 3: Count exact pairs for each GCD using inclusion-exclusion
        long[] gcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalDivisible = 0;
            // Count how many elements are multiples of i
            for (int j = i; j <= maxVal; j += i) {
                totalDivisible += count[j];
            }
            
            // Pairs that share 'i' as a common divisor
            long totalPairs = totalDivisible * (totalDivisible - 1) / 2;
            
            // Subtract pairs that have a larger multiple of i as their actual GCD
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= gcdCount[j];
            }
            
            gcdCount[i] = totalPairs;
        }
        
        // Step 4: Create a prefix sum array of the counts
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + gcdCount[i];
        }
        
        // Step 5: Answer each query using binary search
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            
            // Binary search to find the smallest GCD value where prefixSum[gcd] > q
            int low = 1, high = maxVal;
            int targetGcd = maxVal;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSum[mid] > q) {
                    targetGcd = mid;
                    high = mid - 1; // Try to find a smaller valid GCD
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = targetGcd;
        }
        
        return ans;
    }
}