//Stack Simulation 
 
class Solution { 
    public int[] asteroidCollision(int[] asteroids) { 
 
        // Stack stores surviving asteroids 
        Stack<Integer> st = new Stack<>(); 
 
        // Process each asteroid one by one 
        for (int a : asteroids) { 
 
            // Collision occurs only when: 
            // Current asteroid is moving left (negative) 
            // Stack top is moving right (positive) 
            // Stack top is smaller than current asteroid 
            while (!st.isEmpty() && 
                   a < 0 && 
                   st.peek() > 0 && 
                   st.peek() < -a) { 
 
                // Smaller positive asteroid explodes 
                st.pop(); 
            } 
 
            // Check if collision is still possible 
            if (!st.isEmpty() && 
                a < 0 && 
                st.peek() > 0) { 
 
                // Same size asteroids destroy each other 
                if (st.peek() == -a) { 
                    st.pop(); 
                } 
 
                // If stack top > abs(a), 
                // current asteroid is destroyed 
                // so we do nothing 
 
            } else { 
 
                // No collision 
                // Current asteroid survives 
                st.push(a); 
            } 
        } 
 
        // Create result array of surviving asteroids 
        int[] ans = new int[st.size()]; 
 
        // Stack stores elements in reverse order 
        // Fill array from back to front 
        for (int i = st.size() - 1; i >= 0; i--) { 
            ans[i] = st.pop(); 
        } 
 
        return ans; 
    } 
}