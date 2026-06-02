class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        long mod = 1_000_000_007;

        int[] pse = new int[n]; 
        int[] nse = new int[n]; 

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear(); 
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            long leftDistance = i - pse[i];
            long rightDistance = nse[i] - i;
            
            long totalSubarrays = leftDistance * rightDistance;
            long contribution = (totalSubarrays % mod) * arr[i];
            
            totalSum = (totalSum + contribution) % mod;
        }

        return (int) totalSum;
    }
}