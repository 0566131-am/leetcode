class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Identify the middle character if n is odd
        char midChar = 0;
        int[] halfCnt = new int[26];
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
            halfCnt[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        // Check if total possible palindromic permutations is less than k
        long totalPerms = countPermutations(halfCnt, k);
        if (totalPerms < k) {
            return "";
        }

        // Construct the first half character by character
        char[] firstHalf = new char[halfLen];
        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfCnt[c] == 0) continue;

                // Try placing character c at position i
                halfCnt[c]--;
                long count = countPermutations(halfCnt, k);

                if (k <= count) {
                    firstHalf[i] = (char) ('a' + c);
                    break; // Fixed character at index i
                } else {
                    k -= count;
                    halfCnt[c]++; // Backtrack and try next character
                }
            }
        }

        // Reconstruct the full palindrome
        StringBuilder sb = new StringBuilder();
        sb.append(firstHalf);
        if (n % 2 != 0) {
            sb.append(midChar);
        }
        for (int i = halfLen - 1; i >= 0; i--) {
            sb.append(firstHalf[i]);
        }

        return sb.toString();
    }

    // Helper function to count permutations capped at limit
    private long countPermutations(int[] cnt, long limit) {
        long res = 1;
        int rem = 0;
        for (int c : cnt) {
            rem += c;
        }

        for (int c : cnt) {
            if (c > 0) {
                long ways = comb(rem, c, limit);
                if (limit / ways < res) {
                    return limit + 1;
                }
                res *= ways;
                if (res > limit) {
                    return limit + 1;
                }
                rem -= c;
            }
        }
        return res;
    }

    // Computes nCr capped at limit
    private long comb(int n, int r, long limit) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
            if (res > limit) {
                return limit + 1;
            }
        }
        return res;
    }
}