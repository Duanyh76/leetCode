class Solution {
    public int repeatedNTimes(int[] A) {
        for (int index = 2; index < A.length; index++) {
            if (A[index] == A[index - 1] || A[index] == A[index - 2]) {
                return A[index];
            }
        }
        return A[0];
    }
}