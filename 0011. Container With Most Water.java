class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int size = height.length;
        for (int left = 0; left < size; left++) {
            for (int right = left + 1; right < size; right++) {
                int area = Math.min(height[left], height[right]) * (right - left);
                result = Math.max(result, area);
            }
        }
        return result;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (right > left) {
            int area = (right - left) * Math.min(height[right], height[left]);
            result = Math.max(result, area);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}