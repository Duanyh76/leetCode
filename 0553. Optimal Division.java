class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder expression = new StringBuilder();
        for (int num : nums) {
            expression.append('/');
            expression.append(num);
        }
        expression.deleteCharAt(0);
        if (nums.length > 2) {
            expression.append(')');
            Integer firstNum = nums[0];
            int index = firstNum.toString().length() + 1;
            expression.insert(index, '(');
        }
        return expression.toString();
    }
}