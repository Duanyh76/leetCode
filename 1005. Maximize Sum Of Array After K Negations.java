class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        for (int a : A) {
            if (a < 0 && K > 0) {
                K--;
                a = -a;
            }
            sum += a;
        }
        if (K % 2 == 1) {
            int minNumber = Arrays.stream(A).map(a -> a < 0 ? -a : a).min().getAsInt();
            sum -= 2 * minNumber;
        }
        return sum;
    }
}