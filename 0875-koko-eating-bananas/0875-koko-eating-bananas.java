class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        // The minimum possible eating speed is 1 banana per hour
        int left = 1;
        int right = 0;

        // The maximum reasonable speed is the size of the largest pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary search for the minimum valid speed
        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = 0;

            // Calculate the total hours needed at speed 'mid'
            for (int pile : piles) {
                // Integer trick for ceil(pile / mid) to avoid floating point math
                hours += (pile + mid - 1) / mid; 
            }

            // If Koko can finish within h hours, try a slower speed
            if (hours <= h) {
                right = mid; 
            } else {
                // If it takes too long, we must increase the speed
                left = mid + 1; 
            }
        }

        return left;
    }
}