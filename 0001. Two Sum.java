class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int len = nums.length;
        for (int index = 0; index < len; index++) {
            map.put(nums[index], index);
        }
        int[] answer = new int[2];
        for (int index = 0; index < len; index++) {
            int key = target - nums[index];
            if (map.containsKey(key) && map.get(key) != index) {
                answer[0] = index;
                answer[1] = map.get(key);
                break;
            }
        }
        return answer;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for(int index = 0; index < nums.length; index++){
            if(map.containsKey(nums[index])){
                result[0] = map.get(nums[index]);
                result[1] = index;
                break;
            }else{
                map.put(target - nums[index], index);
            }
        }
        return result;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] orderedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(orderedNums);
        int beginIndex = 0;
        int endIndex = nums.length - 1;
        int a = 0;
        int b = 0;
        while (beginIndex < endIndex) {
            int sum = orderedNums[beginIndex] + orderedNums[endIndex];
            if (sum == target) {
                a = orderedNums[beginIndex];
                b = orderedNums[endIndex];
                break;
            } else if (sum < target) {
                beginIndex++;
            } else {
                endIndex--;
            }
        }
        boolean aFlag = true;
        int[] answer = new int[2];
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == a && aFlag) {
                answer[0] = index;
                aFlag = false;
                continue;
            }
            if (nums[index] == b) {
                answer[1] = index;
            }
        }
        return answer;
    }
}