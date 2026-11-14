import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }
    
    static void backtrack(int n, int openCount, int closeCount, String str, List<String> result) {
        // Base case: when the string reaches length 2 * n, we have a valid combination
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        
        // Choice 1: Add an opening parenthesis if we haven't used all 'n' opening brackets
        if (openCount < n) {
            backtrack(n, openCount + 1, closeCount, str + "(", result);
        }
        
        // Choice 2: Add a closing parenthesis if there are unclosed opening brackets
        if (closeCount < openCount) {
            backtrack(n, openCount, closeCount + 1, str + ")", result);
        }
    }
}