class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int rowIndex = 1; rowIndex < row - 1; rowIndex++) {
            for (int colIndex = 1; colIndex < col - 1; colIndex++) {
                if (grid[rowIndex][colIndex] == 5) {
                    Set<Integer> numbers = new HashSet<>();
                    boolean haveDuplicateNumber = false;
                    for (int i = rowIndex - 1; i <= rowIndex + 1 && haveDuplicateNumber == false; i++) {
                        for (int j = colIndex - 1; j <= colIndex + 1 && haveDuplicateNumber == false; j++) {
                            if (numbers.contains(grid[i][j]) || grid[i][j] > 9 || grid[i][j] < 1) {
                                haveDuplicateNumber = true;
                            }
                            numbers.add(grid[i][j]);
                        }
                    }
                    if (haveDuplicateNumber == true) {
                        continue;
                    }
                    int row1 = grid[rowIndex - 1][colIndex - 1] + grid[rowIndex - 1][colIndex] + grid[rowIndex - 1][colIndex + 1];
                    int row2 = grid[rowIndex][colIndex - 1] + grid[rowIndex][colIndex] + grid[rowIndex][colIndex + 1];
                    int row3 = grid[rowIndex + 1][colIndex - 1] + grid[rowIndex + 1][colIndex] + grid[rowIndex + 1][colIndex + 1];
                    int col1 = grid[rowIndex - 1][colIndex - 1] + grid[rowIndex][colIndex - 1] + grid[rowIndex + 1][colIndex - 1];
                    int col2 = grid[rowIndex - 1][colIndex] + grid[rowIndex][colIndex] + grid[rowIndex + 1][colIndex];
                    int col3 = grid[rowIndex - 1][colIndex + 1] + grid[rowIndex][colIndex + 1] + grid[rowIndex + 1][colIndex + 1];
                    int diagLeft = grid[rowIndex - 1][colIndex - 1] + grid[rowIndex][colIndex] + grid[rowIndex + 1][colIndex + 1];
                    int diagRight = grid[rowIndex + 1][colIndex - 1] + grid[rowIndex][colIndex] + grid[rowIndex - 1][colIndex + 1];
                    if (row1 == 15 && row2 == 15 && row3 == 15 && col1 == 15 && col2 == 15 && col3 == 15 && diagLeft == 15 && diagRight == 15) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}