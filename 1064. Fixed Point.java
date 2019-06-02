class Solution {
    public int fixedPoint(int[] A) {
        for (int index = 0; index < A.length; index++) {
            if (A[index] == index) {
                return index;
            }
        }
        return -1;
    }
}