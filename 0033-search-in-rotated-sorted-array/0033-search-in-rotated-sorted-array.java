class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            // If the target is found, return its index
            if (nums[m] == target) {
                return m;
            }
            
            // Check if the left half is sorted
            if (nums[l] <= nums[m]) {
                // Check if the target lies within the sorted left half
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1; // Search left
                } else {
                    l = m + 1; // Search right
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Check if the target lies within the sorted right half
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1; // Search right
                } else {
                    r = m - 1; // Search left
                }
            }
        }
        
        // Target not found
        return -1;
    }
}