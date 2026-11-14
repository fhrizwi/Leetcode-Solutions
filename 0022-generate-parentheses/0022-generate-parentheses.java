// import java.util.*;

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         backtrack(n, 0, 0, "", result);
//         return result;
//     }
    
//     static void backtrack(int n, int openCount, int closeCount, String str, List<String> result) {
//         // Base case: when the string reaches length 2 * n, we have a valid combination
//         if (str.length() == 2 * n) {
//             result.add(str);
//             return;
//         }
        
//         // Choice 1: Add an opening parenthesis if we haven't used all 'n' opening brackets
//         if (openCount < n) {
//             backtrack(n, openCount + 1, closeCount, str + "(", result);
//         }
        
//         // Choice 2: Add a closing parenthesis if there are unclosed opening brackets
//         if (closeCount < openCount) {
//             backtrack(n, openCount, closeCount + 1, str + ")", result);
//         }
//     }
// }


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        back(n, "", 0, 0, res);
        return res;
    }
    
    void back(int n, String str, int oc, int cc, List<String> res) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        
        // Can add an open bracket if we haven't reached 'n' yet
        if (oc < n) {
            back(n, str + "(", oc + 1, cc, res);
        }
        
        // Can add a close bracket only if open count is greater than close count
        if (cc < oc) {
            back(n, str + ")", oc, cc + 1, res);
        }
    }
}
// }