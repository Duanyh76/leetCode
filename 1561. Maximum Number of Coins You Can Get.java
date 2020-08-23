class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = 0;
        int time = 0;
        int index = piles.length - 2;
        int endFlag = piles.length / 3;
        while(time != endFlag){
            time++;
            count += piles[index];
            index -= 2;
        }
        return count;
    }
}