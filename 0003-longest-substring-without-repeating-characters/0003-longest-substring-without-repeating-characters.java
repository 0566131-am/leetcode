class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int slen = s.length();
        int start = 0, longestSubstring = 0;
        char alphabet;

        for (int end = 0; end < slen; end++) {
            alphabet = s.charAt(end);

            if (map.containsKey(alphabet)) {
                start = Math.max(start, map.get(alphabet) + 1);
            }
            map.put(alphabet, end);
            longestSubstring = Math.max(longestSubstring, end - start + 1);
        }
        return longestSubstring;
    }
}