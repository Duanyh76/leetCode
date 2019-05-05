class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - min - max;
        int minMidDiff = mid - min - 1;
        int midMaxDiff = max - mid - 1;
        int maxMove = minMidDiff + midMaxDiff;
        int minMove = 2;
        if (minMidDiff <= 1 || midMaxDiff <= 1) {
            minMove = 1;
        }
        if (minMidDiff == 0 && midMaxDiff == 0) {
            minMove = 0;
        }
        return new int[]{minMove, maxMove};
    }
}