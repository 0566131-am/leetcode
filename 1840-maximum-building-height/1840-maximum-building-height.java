import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // 1. Prepare and sort restrictions
        // Add two extra slots for building 1 and building n
        int m = restrictions.length;
        int[][] arr = new int[m + 2][2];
        
        for (int i = 0; i < m; i++) {
            arr[i] = restrictions[i];
        }
        // Base case: Building 1 must have height 0
        arr[m] = new int[]{1, 0};
        // Boundary case: Building n has an initial upper bound of n - 1
        arr[m + 1] = new int[]{n, n - 1};
        
        // Sort restrictions by building ID
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        int totalElements = arr.length;
        
        // 2. Left-to-Right Pass
        for (int i = 1; i < totalElements; i++) {
            int maxPossibleFromLeft = arr[i - 1][1] + (arr[i][0] - arr[i - 1][0]);
            arr[i][1] = Math.min(arr[i][1], maxPossibleFromLeft);
        }
        
        // 3. Right-to-Left Pass
        for (int i = totalElements - 2; i >= 0; i--) {
            int maxPossibleFromRight = arr[i + 1][1] + (arr[i + 1][0] - arr[i][0]);
            arr[i][1] = Math.min(arr[i][1], maxPossibleFromRight);
        }
        
        // 4. Calculate the peak height between any two consecutive restricted buildings
        int maxBuildingHeight = 0;
        for (int i = 0; i < totalElements - 1; i++) {
            int id1 = arr[i][0], h1 = arr[i][1];
            int id2 = arr[i + 1][0], h2 = arr[i + 1][1];
            
            // The maximum height reached between building id1 and id2
            int peak = (h1 + h2 + (id2 - id1)) / 2;
            maxBuildingHeight = Math.max(maxBuildingHeight, peak);
        }
        
        return maxBuildingHeight;
    }
}