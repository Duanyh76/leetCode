class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<OrangeState> orangeQueue = new ArrayDeque<>();
        int rowSize = grid.length;
        int colSize = grid[0].length;
        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int colIndex = 0; colIndex < colSize; colIndex++) {
                if (grid[rowIndex][colIndex] == 2) {
                    OrangeState orange = new OrangeState(rowIndex, colIndex, 0);
                    orangeQueue.add(orange);
                }
            }
        }

        int rotTime = 0;
        while (!orangeQueue.isEmpty()) {
            OrangeState orange = orangeQueue.poll();
            int time = orange.time;
            int row = orange.row;
            int col = orange.col;
            rotTime = Math.max(rotTime, time);

            // up
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                OrangeState unrottedOrange = new OrangeState(row - 1, col, time + 1);
                orangeQueue.add(unrottedOrange);
                grid[row - 1][col] = 2;
            }
            // down
            if (row + 1 < rowSize && grid[row + 1][col] == 1) {
                OrangeState unrottedOrange = new OrangeState(row + 1, col, time + 1);
                orangeQueue.add(unrottedOrange);
                grid[row + 1][col] = 2;
            }
            // left
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                OrangeState unrottedOrange = new OrangeState(row, col - 1, time + 1);
                orangeQueue.add(unrottedOrange);
                grid[row][col - 1] = 2;
            }
            // right
            if (col + 1 < colSize && grid[row][col + 1] == 1) {
                OrangeState unrottedOrange = new OrangeState(row, col + 1, time + 1);
                orangeQueue.add(unrottedOrange);
                grid[row][col + 1] = 2;
            }
        }

        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int colIndex = 0; colIndex < colSize; colIndex++) {
                if (grid[rowIndex][colIndex] == 1) {
                    return -1;
                }
            }
        }
        return rotTime;
    }

    class OrangeState {
        int row;
        int col;
        int time;

        public OrangeState(int row, int col, int time) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
}