import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Loop twice from right to left to handle the circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            
            // Remove smaller elements from the stack
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[idx]) {
                stack.pop();
            }
            
            // For the first full pass, record the next greater element
            if (i < n) {
                result[idx] = stack.isEmpty() ? -1 : nums[stack.peek()];
            }
            
            // Push the current index onto the stack
            stack.push(idx);
        }
        
        return result;
    }
}