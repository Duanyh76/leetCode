class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int number = 1;
        for(int t: target){
            while(number < t){
                list.add("Push");
                list.add("Pop");
                number++;
            }
            list.add("Push");
            number++;
        }
        return list;
    }
}