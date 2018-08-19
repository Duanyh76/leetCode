class Solution {
    public String toLowerCase(String str) {
        StringBuilder lowerStrBuilder = new StringBuilder();
        int transferKey = 'a' - 'A';
        for (char letter : str.toCharArray()) {
            if (letter >= 'A' && letter <= 'Z') {
                letter += transferKey;
            }
            lowerStrBuilder.append(letter);
        }
        return lowerStrBuilder.toString();
    }
}