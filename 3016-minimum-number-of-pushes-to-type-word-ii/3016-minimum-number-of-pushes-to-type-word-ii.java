import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        // Step 1: Count character frequencies
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        
        // Step 3: Assign keys from most frequent to least frequent
        // Iterating backwards through the sorted array
        for (int i = 0; i < 26; i++) {
            int count = freq[25 - i];
            if (count == 0) break; // No more characters left
            
            // Calculate push cost:
            // First 8 characters cost 1 push
            // Next 8 characters cost 2 pushes, and so on...
            int cost = (i / 8) + 1;
            totalPushes += count * cost;
        }
        
        return totalPushes;
    }
}