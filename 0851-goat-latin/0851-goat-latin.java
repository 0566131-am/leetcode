class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char ch = word.charAt(0);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(ch);
            }
            sb.append("ma").append("a".repeat(i + 1)).append(" ");
        }

        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}