import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Sort by start ascending; if starts are equal, sort by end descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        int remainingCount = 0;
        int maxEnd = 0;
        
        for (int[] interval : intervals) {
            // If the current interval's end is greater than maxEnd, it's not covered
            if (interval[1] > maxEnd) {
                remainingCount++;
                maxEnd = interval[1]; // Update the furthest reach
            }
        }
        
        return remainingCount;
    }
}