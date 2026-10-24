import java.util.HashSet;

class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // Add all elements to the set
        for (int num : nums) {
            set.add(num);
        }
        // Check for the first positive integer starting from 1
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}