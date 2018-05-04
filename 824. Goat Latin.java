class Solution {
    public String toGoatLatin(String S) {
        StringBuilder goatLatin = new StringBuilder();
        StringBuilder suffix = new StringBuilder("maa");
        S += " ";
        while (!S.isEmpty()) {
            int spaceIndex = S.indexOf(' ');
            StringBuilder word = new StringBuilder(S.substring(0, spaceIndex));
            int size = S.length();
            S = S.substring(spaceIndex + 1, size);
            char firstLetter = word.charAt(0);
            if (!isVowel(firstLetter)) {
                word.deleteCharAt(0);
                word.append(firstLetter);
            }
            word.append(suffix);
            goatLatin.append(word);
            goatLatin.append(' ');
            suffix.append('a');
        }
        goatLatin.deleteCharAt(goatLatin.lastIndexOf(" "));
        return goatLatin.toString();
    }

    private boolean isVowel(char firstLetter) {
        if (firstLetter == 'a' || firstLetter == 'A') {
            return true;
        }
        if (firstLetter == 'e' || firstLetter == 'E') {
            return true;
        }
        if (firstLetter == 'i' || firstLetter == 'I') {
            return true;
        }
        if (firstLetter == 'o' || firstLetter == 'O') {
            return true;
        }
        if (firstLetter == 'u' || firstLetter == 'U') {
            return true;
        }
        return false;
    }
}