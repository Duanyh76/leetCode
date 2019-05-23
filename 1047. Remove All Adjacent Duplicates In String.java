class Solution {
    public String removeDuplicates(String S) {
        int index = 0;
        while (index < S.length() - 1) {
            if (S.charAt(index) == S.charAt(index + 1)) {
                String dupStr = S.substring(index, index + 2);
                S = S.replace(dupStr, "");
                if (index != 0) {
                    index--;
                }
            } else {
                index++;
            }
        }
        return S;
    }
}