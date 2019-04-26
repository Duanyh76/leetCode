class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<Position> buffer = new ArrayList<>();
        for (int rIndex = 0; rIndex < R; rIndex++) {
            for (int cIndex = 0; cIndex < C; cIndex++) {
                int distance = Math.abs(rIndex - r0) + Math.abs(cIndex - c0);
                Position position = new Position(rIndex, cIndex, distance);
                buffer.add(position);
            }
        }
        int[][] sortedArray = new int[R * C][2];
        int index = 0;
        List<Position> sortedBuffer =
                buffer.stream()
                        .sorted(Comparator.comparingInt(Position::getDistance))
                        .collect(Collectors.toList());
        for (Position position : sortedBuffer) {
            sortedArray[index][0] = position.r;
            sortedArray[index][1] = position.c;
            index++;
        }
        return sortedArray;
    }

    class Position {
        int r;
        int c;
        int distance;

        public Position(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }
    }
}