class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        // Construct the augmented string
        String t = "1" + s + "1";
        
        // Count initial ones in s
        int initialOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                initialOnes++;
            }
        }

        // Store lengths of alternating blocks
        // Record block type ('1' or '0') and its length
        java.util.List<Integer> lengths = new java.util.ArrayList<>();
        java.util.List<Character> types = new java.util.ArrayList<>();

        int n = t.length();
        int i = 0;
        while (i < n) {
            char ch = t.charAt(i);
            int j = i;
            while (j < n && t.charAt(j) == ch) {
                j++;
            }
            types.add(ch);
            lengths.add(j - i);
            i = j;
        }

        int maxDelta = 0;

        // Iterate through blocks and look for '1'-blocks surrounded by '0'-blocks
        for (int k = 1; k < types.size() - 1; k++) {
            if (types.get(k) == '1' && types.get(k - 1) == '0' && types.get(k + 1) == '0') {
                int leftZeros = lengths.get(k - 1);
                int rightZeros = lengths.get(k + 1);
                maxDelta = Math.max(maxDelta, leftZeros + rightZeros);
            }
        }

        return initialOnes + maxDelta;
    }
}