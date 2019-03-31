class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        long count = Arrays.stream(A).sum() / 3;
        int arrayLength = A.length;
        long partionCount = 0;
        int index = 0;
        int groupNum = 0;
        for (; index < arrayLength; index++) {
            if (partionCount == count) {
                groupNum++;
                partionCount = 0;
            }
            if (groupNum == 2) {
                return true;
            }
            partionCount += A[index];
        }
        return false;
    }
}