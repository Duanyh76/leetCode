class Solution {
    public int minDeletionSize(String[] A) {
        int num = A.length;
        int length = A[0].length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < num; j++) {
                char a = A[j].charAt(i);
                char b = A[j - 1].charAt(i);
                if (a < b) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}