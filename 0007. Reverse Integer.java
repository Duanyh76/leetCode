class Solution {
    public int reverse(int x) {
        long rx = 0;
        while(x != 0){
            int key = x % 10;
            rx = rx * 10 + key;
            x /= 10;
        }
        if(rx > Integer.MAX_VALUE || rx < Integer.MIN_VALUE){
            return 0;
        }
        return (int)rx;
    }
}