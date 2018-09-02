class Solution {
    public boolean isMonotonic(int[] A) {
        int size = A.length;
        int diff = A[0] - A[size - 1];
        int type = diff == 0 ? 0 : (diff > 0 ? 1 : -1);
        /**
         * equal:0
         * increase:-1
         * decrease:1
         * */
        for (int index = 1; index < size; index++) {
            int localDiff = A[index - 1] - A[index];
            int localType = localDiff == 0 ? 0 : (localDiff > 0 ? 1 : -1);
            if (localType != 0) {
                if (localType != type) {
                    return false;
                }
            }
        }
        return true;
    }
}