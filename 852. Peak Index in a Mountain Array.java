class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int index = 1;
        while (index < A.length - 1 && A[index - 1] < A[index]) {
            index++;
        }
        return index - 1;
    }
}