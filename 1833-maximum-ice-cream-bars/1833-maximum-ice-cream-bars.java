class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Step 1: Find the maximum cost to size our frequency array
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }
        
        // Step 2: Create a frequency array (Counting Sort buckets)
        int[] freq = new int[maxCost + 1];
        for (int cost : costs) {
            freq[cost]++;
        }
        
        int iceCreamCount = 0;
        
        // Step 3: Greedily buy ice cream from cheapest to most expensive
        for (int price = 1; price <= maxCost; price++) {
            if (freq[price] == 0) {
                continue;
            }
            
            // If we can't even afford a single bar at this price, we are done
            if (coins < price) {
                break;
            }
            
            // Total cost required to buy all available bars at this price point
            long totalCostForBars = (long) price * freq[price];
            
            if (coins >= totalCostForBars) {
                // Buy all of them
                iceCreamCount += freq[price];
                coins -= totalCostForBars;
            } else {
                // Buy as many as possible with remaining coins
                int countToBuy = coins / price;
                iceCreamCount += countToBuy;
                break; // Out of coins
            }
        }
        
        return iceCreamCount;
    }
}