class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumList = new ArrayList<>();
        Set<String> unDupSet = new HashSet<>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            List<List<Integer>> twoSumList = twoSum(nums, index);
            twoSumList.stream().forEach(list -> {
                String s = list.toString();
                if (!unDupSet.contains(s)) {
                    threeSumList.add(list);
                    unDupSet.add(s);
                }
            });
        }
        return threeSumList;
    }

    private List<List<Integer>> twoSum(int[] nums, int valueIndex) {
        List<List<Integer>> twoSumList = new ArrayList<>();
        if (valueIndex >= nums.length - 2) {
            return twoSumList;
        }
        for (int index = valueIndex + 1; index < nums.length - 1; index++) {
            int value = -(nums[valueIndex] + nums[index]);
            if (findValue(nums, index + 1, value)) {
                List<Integer> sum = new ArrayList<>();
                sum.add(nums[valueIndex]);
                sum.add(nums[index]);
                sum.add(value);
                twoSumList.add(sum);
            }
        }
        return twoSumList;
    }

    private boolean findValue(int[] nums, int beginIndex, int value) {
        int endIndex = nums.length - 1;
        while (beginIndex <= endIndex) {
            int midIndex = beginIndex + (endIndex - beginIndex) / 2;
            if (nums[midIndex] == value) {
                return true;
            }
            if (nums[midIndex] < value) {
                beginIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return false;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;
        for (int index = 0; index < len - 2; index++) {
            if (index == 0 || nums[index] != nums[index - 1]) {
                int target = -1 * nums[index];
                int midIndex = index + 1;
                int endIndex = len - 1;
                while (midIndex < endIndex) {
                    int sum = nums[midIndex] + nums[endIndex];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[index], nums[midIndex], nums[endIndex]);
                        result.add(list);
                        while (midIndex < endIndex && nums[midIndex] == nums[midIndex + 1]) {
                            midIndex++;
                        }
                        while (midIndex < endIndex && nums[endIndex] == nums[endIndex - 1]) {
                            endIndex--;
                        }
                        midIndex++;
                        endIndex--;
                    } else if (sum < target) {
                        midIndex++;
                    } else {
                        endIndex--;
                    }
                }
            }
        }
        return result;
    }
}