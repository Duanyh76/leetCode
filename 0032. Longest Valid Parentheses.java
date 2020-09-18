class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        char[] ps = s.toCharArray();
        boolean[] record = new boolean[ps.length];
        for (int index = 0; index < ps.length; index++) {
            char p = ps[index];
            if (p == '(') {
                stack.push(p);
                indexStack.push(index);
            } else {
                // p == ')'
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    Integer leftIndex = indexStack.pop();
                    for (int i = leftIndex; i <= index; i++) {
                        record[i] = true;
                    }
                }
            }
        }

        int maxValue = 0;
        int value = 0;
        for (boolean r : record) {
            if (r) {
                value++;
            } else {
                maxValue = Math.max(maxValue, value);
                value = 0;
            }
        }
        maxValue = Math.max(maxValue, value);
        return maxValue;
    }
}