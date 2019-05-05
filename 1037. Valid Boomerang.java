class Solution {
    public boolean isBoomerang(int[][] points) {
        double[] direct1 = getDirect(points[0], points[1]);
        double[] direct2 = getDirect(points[0], points[2]);
        if (direct1[0] == 0 && direct1[1] == 0) {
            return false;
        }
        if (direct2[0] == 0 && direct2[1] == 0) {
            return false;
        }
        if (direct1[0] == direct2[0] && direct1[1] == direct2[1]) {
            return false;
        }
        if (direct1[0] == -direct2[0] && direct1[1] == -direct2[1]) {
            return false;
        }
        return true;
    }

    private double[] getDirect(int[] source, int[] target) {
        double[] direct = new double[2];
        direct[0] = source[0] - target[0];
        direct[1] = source[1] - target[1];
        double length = Math.sqrt(direct[0] * direct[0] + direct[1] * direct[1]);
        if (length == 0) {
            return new double[2];
        }
        direct[0] /= length;
        direct[1] /= length;
        return direct;
    }
}