class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumRecord = new HashMap<>();
        calculateTreeSum(root, sumRecord);
        int maxFreq = 0;
        for (int sum : sumRecord.keySet()) {
            maxFreq = Math.max(maxFreq, sumRecord.get(sum));
        }
        List<Integer> maxFreqSum = new ArrayList<>();
        for (int sum : sumRecord.keySet()) {
            if (sumRecord.get(sum) == maxFreq) {
                maxFreqSum.add(sum);
            }
        }
        int size = maxFreqSum.size();
        int[] sumArray = new int[size];
        for (int i = 0; i < size; i++) {
            sumArray[i] = maxFreqSum.get(i);
        }
        return sumArray;
    }

    private int calculateTreeSum(TreeNode root, Map<Integer, Integer> sumRecord) {
        if (root == null) {
            return 0;
        }
        int leftSum = calculateTreeSum(root.left, sumRecord);
        int rightSum = calculateTreeSum(root.right, sumRecord);
        int sum = leftSum + rightSum + root.val;
        int freq = sumRecord.containsKey(sum) ? sumRecord.get(sum) : 0;
        sumRecord.remove(sum);
        sumRecord.put(sum, freq + 1);
        return sum;
    }
}