class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing((a) -> a.length()));
        int[] chains = new int[words.length];
        int maxChainLength = 0;
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            int maxSubChainLength = 0;
            String word = words[wordIndex];
            for (int chainIndex = 0; chainIndex < wordIndex; chainIndex++) {
                String preWord = words[chainIndex];
                if (isPredecessor(preWord, word)) {
                    maxSubChainLength = Math.max(maxSubChainLength, chains[chainIndex]);
                }
            }
            chains[wordIndex] = maxSubChainLength + 1;
            maxChainLength = Math.max(maxChainLength, maxSubChainLength + 1);
        }
        return maxChainLength;
    }

    private boolean isPredecessor(String preWord, String word) {
        if (preWord.length() != word.length() - 1) {
            return false;
        }
        int preWordIndex = 0;
        int wordIndex = 0;
        while (preWordIndex < preWord.length() && wordIndex < word.length()) {
            if (preWord.charAt(preWordIndex) != word.charAt(wordIndex)) {
                preWordIndex--;
            }
            if (wordIndex - preWordIndex == 2) {
                return false;
            }
            wordIndex++;
            preWordIndex++;
        }
        return true;
    }
}