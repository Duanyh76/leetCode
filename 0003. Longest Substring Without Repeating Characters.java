class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> record = new HashMap();
        int length = 0;   
        int maxLength = 0;
        int index = -1;
        for(char c : s.toCharArray()){
            index++;
            if(record.get(c) == null){
                length++;
            }else{
                int preIndex = record.get(c);
                length = Math.min(index - preIndex, length + 1);
            }
            record.put(c, index);
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}