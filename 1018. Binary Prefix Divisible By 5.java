class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int number = 0;
        List<Boolean> solution = new ArrayList<>();
        for (int a : A) {
            number = (number * 2 + a) % 10;
            if (number % 5 == 0) {
                solution.add(true);
            } else {
                solution.add(false);
            }
        }
        return solution;
    }
}