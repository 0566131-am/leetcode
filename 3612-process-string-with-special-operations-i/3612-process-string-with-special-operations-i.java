class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '*') {
                // Remove the last character if it exists
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                // Duplicate the current result and append it to itself
                result.append(result.toString());
            } else if (ch == '%') {
                // Reverse the current result
                result.reverse();
            } else {
                // Regular lowercase letter: append to result
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}