class Solution {
    public int maxDistToClosest(int[] seats) {
        List<Integer> sittingIndex = new ArrayList<>();
        for (int index = 0; index < seats.length; index++) {
            if (seats[index] == 1) {
                sittingIndex.add(index);
            }
        }
        int maxDistance = seats[seats.length - 1] == 1 ? 0 : seats.length - 1 - sittingIndex.get(sittingIndex.size() - 1);
        maxDistance *= 2;
        for (int people = 1; people < sittingIndex.size(); people++) {
            maxDistance = Math.max(maxDistance, sittingIndex.get(people) - sittingIndex.get(people - 1));
        }
        maxDistance /= 2;
        if (seats[0] == 0) {
            maxDistance = Math.max(maxDistance, sittingIndex.get(0));
        }
        return maxDistance;
    }
}