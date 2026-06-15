class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        // Initialize the binary search range
        int left = 1;
        int right = *max_element(piles.begin(), piles.end());
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Calculate total hours needed if Koko eats at speed 'mid'
            long long totalHours = 0;
            for (int pile : piles) {
                // Ceil division without using floating-point types to prevent precision issues
                totalHours += (pile + mid - 1) / mid;
            }

            // If she can finish within h hours, try to find a slower (smaller) speed
            if (totalHours <= h) {
                result = mid;       // 'mid' is a valid speed candidate
                right = mid - 1;    // narrow search to the left half
            } else {
                left = mid + 1;     // 'mid' is too slow, we need a faster speed
            }
        }

        return result;
    }
};