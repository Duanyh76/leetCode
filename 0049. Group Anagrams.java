class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> records = new HashMap<>();
        for(String str: strs){
            int[] record = new int[26];
            for(char ch: str.toCharArray()){
                int index = ch - 'a';
                record[index]++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int index = 0; index < 26; index++){
                char letter = (char)('a' + index);
                int times = record[index];
                keyBuilder.append(times);
                keyBuilder.append(letter);
            }
            String key = keyBuilder.toString();
            if(records.containsKey(key)){
                records.get(key).add(str);
            }else{
                List<String> value = new ArrayList<>();
                value.add(str);
                records.put(key, value);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: records.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}