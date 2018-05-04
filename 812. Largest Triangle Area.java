class Solution {
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int[] i : points) {
            for (int[] j : points) {
                for (int[] k : points) {
                    double tempArea = i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - i[0] * k[1] - k[0] * j[1] - j[0] * i[1];
                    area = Math.max(area, tempArea);
                }
            }
        }
        return area / 2;
    }
}