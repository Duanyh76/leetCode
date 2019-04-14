class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int ans[] = new int[2];
        int length = S.length();
        int lines = 1;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int index = S.charAt(i) - 'a';
            int wordNum = widths[index];
            if (count + wordNum <= 100) {
                count += wordNum;
            } else {
                count = wordNum;
                lines++;
            }
        }
        ans[0] = lines;
        ans[1] = count;
        return ans;
    }
}