class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> words = new HashMap<>();
        Set<String> bannedWord = new HashSet<>(Arrays.asList(banned));
        int maxCount = 0;
        String commonWord = null;
        for (String word : paragraph.split(" ")) {
            word = word.toLowerCase();
            char lastLetter = word.charAt(word.length()-1);
            if (lastLetter < 'a' || lastLetter > 'z') {
                word = word.substring(0, word.length() - 1);
            }
            if (!bannedWord.contains(word)) {
                int count = 1;
                if (words.containsKey(word)) {
                    count += words.get(word);
                    words.remove(word);
                }
                words.put(word, count);
                if (maxCount < count) {
                    maxCount = count;
                    commonWord = word;
                }
            }
        }
        return commonWord;
    }
}