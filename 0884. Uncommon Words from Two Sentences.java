class Solution {
    private Map<String, Integer> wordMap = new HashMap<>();

    public String[] uncommonFromSentences(String A, String B) {
        deal(A.split(" "));
        deal(B.split(" "));
        List<String> uncommonList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonList.add(entry.getKey());
            }
        }
        String[] array = new String[uncommonList.size()];
        return uncommonList.toArray(array);
    }

    private void deal(String[] list) {
        for (String word : list) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
    }
}