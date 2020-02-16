class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLength = -1;
        String result = "";
        for (int len = 1; len <= length; len++) {
            int endOfBeginIndex = length + 1 - len;
            for (int beginIndex = 0; beginIndex < endOfBeginIndex; beginIndex++) {
                int endIndex = beginIndex + len - 1;
                if (s.charAt(beginIndex) == s.charAt(endIndex)) {
                    if (beginIndex + 1 >= endIndex - 1 || dp[beginIndex + 1][endIndex - 1] == true) {
                        dp[beginIndex][endIndex] = true;
                        int tmpLen = endIndex - beginIndex + 1;
                        if (tmpLen > maxLength) {
                            maxLength = tmpLen;
                            result = s.substring(beginIndex, endIndex + 1);
                        }
                    } else {
                        dp[beginIndex][endIndex] = false;
                    }
                }
            }
        }
        return result;
    }
}