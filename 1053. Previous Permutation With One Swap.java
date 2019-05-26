class Solution {
    public int[] prevPermOpt1(int[] A) {
        if (A.length == 1) {
            return A;
        }
        for (int index = A.length - 2; index >= 0; index--) {
            int maxMinNumIndex = getIndex(A, index);
            if (A[index] > A[maxMinNumIndex]) {
                int temp = A[index];
                A[index] = A[maxMinNumIndex];
                A[maxMinNumIndex] = temp;
                break;
            }
        }
        return A;
    }

    private int getIndex(int[] A, int compareIndex) {
        int keyNum = 0;
        int keyIndex = compareIndex;
        for (int index = A.length - 1; index > compareIndex; index--) {
            if (A[index] < A[compareIndex] && A[index] >= keyNum) {
                keyNum = A[index];
                keyIndex = index;
            }
        }
        return keyIndex;
    }
}