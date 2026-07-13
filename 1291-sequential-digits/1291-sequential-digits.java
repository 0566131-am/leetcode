import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // Populate the queue with single-digit starting numbers (1-8)
        // 9 cannot start a sequential digit number because the next digit must be 10
        for (int i = 1; i <= 8; i++) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            
            // If the number is within range, add it to our list
            if (num >= low && num <= high) {
                result.add(num);
            }
            
            // Get the last digit of the current number
            int lastDigit = num % 10;
            
            // If the last digit is less than 9, we can append (lastDigit + 1)
            if (lastDigit < 9) {
                int nextNum = num * 10 + (lastDigit + 1);
                
                // Optimization: Only push to the queue if it hasn't exceeded 'high'
                if (nextNum <= high) {
                    queue.add(nextNum);
                }
            }
        }
        
        // The queue inherently processes numbers by length (12, 23... then 123, 234...)
        // So the result list is already sorted!
        return result;
    }
}