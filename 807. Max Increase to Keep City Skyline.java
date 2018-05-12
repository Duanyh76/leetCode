class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[] maxRowList = new int[rowSize];
        int[] maxColList = new int[colSize];
        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int colIndex = 0; colIndex < colSize; colIndex++) {
                maxRowList[rowIndex] = Math.max(maxRowList[rowIndex], grid[rowIndex][colIndex]);
                maxColList[colIndex] = Math.max(maxColList[colIndex], grid[rowIndex][colIndex]);
            }
        }
        int count = 0;
        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int colIndex = 0; colIndex < colSize; colIndex++) {
                count += Math.min(maxColList[colIndex], maxRowList[rowIndex]) - grid[rowIndex][colIndex];
            }
        }
        return count;
    }
}