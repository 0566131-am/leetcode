class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }
        int maxFreqCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxFreqCount++;
            }
        }
        int chunks = maxFreq - 1;
        int chunkSize = n + 1;
        int minimumTotal = (chunks * chunkSize) + maxFreqCount;
        return Math.max(tasks.length, minimumTotal);
    }
}