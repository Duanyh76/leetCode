class Solution {
    public boolean backspaceCompare(String S, String T) {
        String s = deleteBackspace(S);
        String t = deleteBackspace(T);
        return s.equals(t);
    }

    public String deleteBackspace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : s.toCharArray()) {
            if (letter == '#') {
                if (stringBuilder.length() != 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            } else {
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }
}