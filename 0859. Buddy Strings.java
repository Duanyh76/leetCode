class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.isEmpty() || B.isEmpty() || A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            int[] record = new int[26];
            for (int i = 0; i < A.length(); i++) {
                record[A.charAt(i) - 'a']++;
                if (record[A.charAt(i) - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        int[] diffIndexRecord = new int[2];
        int diffIndex = 0;
        for (int index = 0; index < A.length(); index++) {
            if (A.charAt(index) != B.charAt(index)) {
                if (diffIndex == 2) {
                    return false;
                }
                diffIndexRecord[diffIndex++] = index;
            }
        }
        int firstIndex = diffIndexRecord[0];
        int secondIndex = diffIndexRecord[1];
        if (A.charAt(firstIndex) == B.charAt(secondIndex) && A.charAt(secondIndex) == B.charAt(firstIndex)) {
            return true;
        }
        return false;
    }
}