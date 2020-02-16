class Solution {
    public int myAtoi(String str) {
        char[] array = str.toCharArray();
        int len = str.length();
        int index = 0;
        while (index < len && array[index] == ' ') {
            index++;
        }
        int factor = 1;
        if (index < len && (array[index] == '+' || array[index] == '-')) {
            if (array[index] == '-') {
                factor = -1;
            }
            index++;
        }
        long num = 0;
        while (index < len && array[index] >= '0' && array[index] <= '9') {
            num = num * 10 + factor * (array[index] - '0');
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) num;
    }
}