class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        
        // Count frequencies of the required characters
        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }
        
        // 'l' and 'o' are needed twice per word, so divide their counts by 2
        l /= 2;
        o /= 2;
        
        // The bottleneck (minimum count) determines the total words we can form
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}