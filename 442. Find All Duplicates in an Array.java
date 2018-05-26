class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numberSet.contains(nums[i])) {
                numberSet.add(nums[i]);
            } else {
                numbers.add(nums[i]);
            }
        }
        return numbers;
    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> twiceNumbers = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                twiceNumbers.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return twiceNumbers;
    }
}