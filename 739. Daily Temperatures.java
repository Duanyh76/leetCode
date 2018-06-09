class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] days = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (temperatures[j] > temperatures[i]) {
                    days[i] = j - i;
                    break;
                }
            }
        }
        return days;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] warmerDays = new int[size];
        Stack<List<Integer>> record = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!record.empty() && record.peek().get(1) < temperatures[i]) {
                int colderDay = record.peek().get(0);
                warmerDays[colderDay] = i - colderDay;
                record.pop();
            }
            record.push(Arrays.asList(i, temperatures[i]));
        }
        return warmerDays;
    }
}