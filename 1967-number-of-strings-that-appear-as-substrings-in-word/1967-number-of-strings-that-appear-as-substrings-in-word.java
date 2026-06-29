class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        
        // Iterate through each pattern in the array
        for (String pattern : patterns) {
            // Check if the current pattern is a substring of word
            if (word.contains(pattern)) {
                count++;
            }
        }
        
        return count;
    }
}