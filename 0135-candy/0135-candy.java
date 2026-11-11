class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int can[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            can[i] = 1;
        }
        
        // Left to Right Pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                can[i] = can[i - 1] + 1;
            }
        }
        
        // Right to Left Pass
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                can[i - 1] = Math.max(can[i - 1], can[i] + 1);
            }
        }
        
        // Calculate Total Candies
        int s = 0;
        for (int i : can) {
            s += i;
        }
        
        return s;
    }
}