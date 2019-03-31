class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] typeArray = new int[60];
        for (int song : time) {
            int type = song % 60;
            typeArray[type]++;
        }
        int count = 0;
        for (int type = 1; type < 30; type++) {
            count += typeArray[type] * typeArray[60 - type];
        }
        if (typeArray[0] != 0) {
            count += typeArray[0] * (typeArray[0] - 1) / 2;
        }
        if (typeArray[30] != 0) {
            count += typeArray[30] * (typeArray[30] - 1) / 2;
        }
        return count;
    }
}