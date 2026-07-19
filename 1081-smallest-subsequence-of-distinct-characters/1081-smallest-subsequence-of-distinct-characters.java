class Solution {
    public String smallestSubsequence(String s) {
        // Track the last seen index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Track whether a character is already included in the result stack
        boolean[] visited = new boolean[26];
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character is already in our subsequence, skip it
            if (visited[c - 'a']) {
                continue;
            }
            
            // Maintain the lexicographically smallest property
            // Pop the top character if it's larger than the current character
            // AND it appears later in the remaining string
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > c && 
                   lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                
                char popped = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                visited[popped - 'a'] = false;
            }
            
            // Append current character and mark as visited
            stack.append(c);
            visited[c - 'a'] = true;
        }
        
        return stack.toString();
    }
}