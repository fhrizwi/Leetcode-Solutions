import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, l = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
        return max;
    }
}













//bruteforce
// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         for (int i = 0; i < s.length(); i++) {
//             Set<Character> set = new HashSet<>();
//             for (int j = i; j < s.length(); j++) {
//                 char ch = s.charAt(j);
//                 if (set.contains(ch)) {
//                     break;
//                 }
//                 set.add(ch);
//                 max = Math.max(max, set.size());
//             }
//         }
//         return max;
//     }
// }