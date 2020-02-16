class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int len = s.length();
        int col = (len / (2 * numRows - 2)) * (numRows - 1);
        int remains = len % (2 * numRows - 2);
        col += (remains <= numRows ? 1 : remains - numRows + 1);
        char[][] matrix = new char[numRows][col];
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                matrix[rowIndex][colIndex] = ' ';
            }
        }
        int rowIndex = 0;
        int colIndex = 0;
        String direction = "down";
        for (char letter : s.toCharArray()) {
            matrix[rowIndex][colIndex] = letter;
            if (direction.equals("down")) {
                if (rowIndex == numRows - 1) {
                    direction = "upRight";
                    rowIndex--;
                    colIndex++;
                } else {
                    rowIndex++;
                }
            } else {
                if (rowIndex == 0) {
                    direction = "down";
                    rowIndex++;
                } else {
                    rowIndex--;
                    colIndex++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (colIndex = 0; colIndex < col; colIndex++) {
                if (matrix[rowIndex][colIndex] != ' ') {
                    sb.append(matrix[rowIndex][colIndex]);
                }
            }
        }
        return sb.toString();
    }
}