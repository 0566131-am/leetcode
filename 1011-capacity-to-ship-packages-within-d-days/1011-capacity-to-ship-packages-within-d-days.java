class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;    
        }
        
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canShip(weights, days, mid)) {
                result = mid;       
                right = mid - 1;     
            } else {
                left = mid + 1;      
            }
        }
        
        return result;
    }
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;
        
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;        
                currentLoad = 0;   
            }
            currentLoad += w;
        }
        return daysNeeded <= days;
    }
}