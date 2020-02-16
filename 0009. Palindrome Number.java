class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        long factorL = 1;
        while (factorL <= x) {
            factorL *= 10;
        }
        int factor = (int) (factorL / 10);
        int key = 1;
        while (factor >= key && x != 0) {
            int a = x / factor;
            int b = (x / key) % 10;
            if (a != b) {
                return false;
            }
            x -= a * factor;
            x -= b;
            factor /= 10;
            key *= 10;
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        int cache = x;
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return cache == result;
    }
}