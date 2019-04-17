class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < 1 && N == 1) {
            return 1;
        }
        Map<Integer, Integer> judge = new HashMap<>();
        Set<Integer> normal = new HashSet<>();
        for (int[] trustPair : trust) {
            int a = trustPair[0];
            int b = trustPair[1];
            if (judge.containsKey(a)) {
                judge.remove(a);
            }
            normal.add(a);
            if (!normal.contains(b)) {
                Integer count = judge.get(b) == null ? 0 : judge.get(b);
                judge.put(b, ++count);
            }
        }
        if (judge.size() != 1) {
            return -1;
        }
        for (Map.Entry<Integer, Integer> person : judge.entrySet()) {
            if (person.getValue() == N - 1) {
                return person.getKey();
            } else {
                return -1;
            }
        }
        return -1;
    }
}