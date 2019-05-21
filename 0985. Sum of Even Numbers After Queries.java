class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] countArray = new int[A.length];
        int evenCount = Arrays.stream(A).filter(a -> a % 2 == 0).sum();
        for (int index = 0; index < A.length; index++) {
            int val = queries[index][0];
            int aIndex = queries[index][1];
            if (A[aIndex] % 2 == 0) {
                // already even
                if (val % 2 == 0) {
                    // even too
                    evenCount += val;
                } else {
                    // sum odd
                    evenCount -= A[aIndex];
                }
            } else {
                // already odd
                if (val % 2 != 0) {
                    // sum even
                    evenCount += val + A[aIndex];
                }
            }
            A[aIndex] += val;
            countArray[index] = evenCount;
        }
        return countArray;
    }
}