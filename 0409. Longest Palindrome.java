public class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[52];
        char[] array = s.toCharArray();
        for (int index = 0; index < array.length; index++) {
            char letter = array[index];
            int letterIndex = 0;
            if (letter >= 'a') {
                letterIndex = letter - 'a' + 26;
            } else {
                letterIndex = letter - 'A';
            }
            map[letterIndex]++;
        }
        boolean single = false;
        int len = 0;
        for (int index = 0; index < 52; index++) {
            if (map[index] % 2 == 1) {
                single = true;
                len += map[index] - 1;
            } else {
                len += map[index];
            }
        }
        if (single) {
            len++;
        }
        return len;
    }
}

public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        char[] array = s.toCharArray();
        int count = 0;
        for (int index = 0; index < array.length; index++) {
            char letter = array[index];
            if (set.contains(letter)) {
                set.remove(letter);
                count++;
            } else {
                set.add(letter);
            }
        }
        count *= 2;
        if (set.isEmpty()) {
            return count;
        }
        return count + 1;
    }
}