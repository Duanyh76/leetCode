class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.contains("1") || digits.contains("0")) {
            return new ArrayList();
        }
        String[] array = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Stack<String> aStack = new Stack();
        Stack<String> bStack = new Stack();
        Stack<String> cStack = null;
        boolean startFlag = true;
        for (char digit : digits.toCharArray()) {
            int index = digit - '2';
            char[] letterGroup = array[index].toCharArray();
            while (startFlag || !aStack.isEmpty()) {
                String word = "";
                if(!startFlag){
                    word = aStack.pop();
                }
                startFlag = false;
                for (char letter : letterGroup) {
                    String newWord = word + letter;
                    bStack.push(newWord);
                }
            }
            cStack = aStack;
            aStack = bStack;
            bStack = cStack;
        }
        return new ArrayList(aStack);
    }
}