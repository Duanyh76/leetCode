class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] records = new int[n+1];
        int length = rounds.length;
        
        for(int index = 0; index < length -1 ; index++){
            int begin = rounds[index];
            int end = rounds[index + 1];
            if(begin == end){
                continue;
            }else if(begin < end){
                for(int i = begin + 1; i <= end; i++){
                    records[i]++;
                }
            }else{
                int b = end + 1;
                int e = begin;
                for(int i = b; i <= e; i++){
                    records[i]--;
                }
            }
        }
        records[rounds[0]]++;
        
        int maxCount = Integer.MIN_VALUE;
        for(int index = 1; index <= n; index++){
            maxCount = Math.max(records[index], maxCount);
        }
        List<Integer> result = new ArrayList();
        for(int index = 1; index <=n; index++){
            if(records[index] == maxCount){
                result.add(index);
            }
        }
        return result;
    }
}