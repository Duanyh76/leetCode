class Solution {
    public int countSubstrings(String s) {
        int size = s.length();
        int count = size;
        int[][] stringMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                stringMatrix[i][j] = 0;
            }
            stringMatrix[i][i] = 1;
        }

        for (int length = 2; length <= size; length++) {
            for (int beginIndex = 0; beginIndex <= size - length; beginIndex++) {
                int endIndex = beginIndex + length - 1;
                if ((stringMatrix[beginIndex + 1][endIndex - 1] == 1 && s.charAt(beginIndex) == s.charAt(endIndex)) ||
                        (endIndex - beginIndex == 1 && s.charAt(beginIndex) == s.charAt(endIndex))) {
                    stringMatrix[beginIndex][endIndex] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}