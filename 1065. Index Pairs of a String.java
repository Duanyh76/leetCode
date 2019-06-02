class Solution {
    private List<int[]> pairList = new ArrayList<>();

    public int[][] indexPairs(String text, String[] words) {
        for (String word : words) {
            getPair(word, text);
        }
        int[][] pairs = pairList.toArray(new int[pairList.size()][]);
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] > 0) {
                    return 1;
                } else if (o1[0] - o2[0] < 0) {
                    return -1;
                } else if (o1[1] - o2[1] > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return pairs;
    }

    private void getPair(String word, String text) {
        int beginIndex = 0;
        while (beginIndex < text.length()) {
            int wordIndex = text.indexOf(word, beginIndex);
            if (wordIndex == -1) {
                return;
            }
            int endIndex = wordIndex + word.length() - 1;
            int[] pair = {wordIndex, endIndex};
            pairList.add(pair);
            beginIndex = wordIndex + 1;
        }
    }
}