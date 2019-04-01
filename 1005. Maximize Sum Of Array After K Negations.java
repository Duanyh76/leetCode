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

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(A).forEach(a -> queue.add(a));
        while (K > 0) {
            K--;
            queue.add(queue.poll() * -1);
        }
        return queue.stream().mapToInt(a -> a).sum();
    }
}