class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Change the type to 'long' to prevent overflow
        long reversedNumber = 0;
        int original = x;

        while (x > 0) {
            int lastDigit = x % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            x /= 10;
        }

        return original == (int)reversedNumber;
    }
};