class Solution {
    public int twoCitySchedCost(int[][] costs) {
        List<CostDiff> diffList = new ArrayList<>();
        for (int index = 0; index < costs.length; index++) {
            int diff = costs[index][0] - costs[index][1];
            CostDiff costDiff = new CostDiff(diff, index);
            diffList.add(costDiff);
        }
        List<CostDiff> sortedList =
                diffList.stream()
                        .sorted(Comparator.comparingInt(CostDiff::getDiff))
                        .collect(Collectors.toList());
        int half = costs.length / 2;
        int costCount = 0;
        for (int i = 0; i < half; i++) {
            int index = sortedList.get(i).index;
            int cost = costs[index][0];
            costCount += cost;
            index = sortedList.get(i + half).index;
            cost = costs[index][1];
            costCount += cost;
        }
        return costCount;
    }

    class CostDiff {
        int diff;
        int index;

        public CostDiff(int diff, int index) {
            this.diff = diff;
            this.index = index;
        }

        public int getDiff() {
            return diff;
        }
    }
}

class Solution {
    List<Integer> costList = new ArrayList<>();

    public int twoCitySchedCost(int[][] costs) {
        int peopleNum = costs.length;
        int flag = peopleNum / 2;
        caculate(costs, 0, 0, flag);
        int minCost = (int) costList.stream().min(Integer::compare).get();
        return minCost;
    }

    private void caculate(int[][] costs, int index, int cost, int flag) {
        if (index == costs.length) {
            if (flag == 0) {
                costList.add(cost);
            }
            return;
        }
        caculate(costs, index + 1, cost + costs[index][0], flag);
        if (flag >= 0) {
            caculate(costs, index + 1, cost + costs[index][1], flag - 1);
        }
    }
}

