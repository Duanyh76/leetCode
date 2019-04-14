class Solution {
   public String removeOuterParentheses(String S) {
        StringBuilder parentGroup = new StringBuilder();
        StringBuilder parentChild = new StringBuilder();
        int leftCount = 0;
        int rightCount = 0;

        for (char parent : S.toCharArray()) {
            if (parent == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            parentChild.append(parent);

            if (leftCount == rightCount) {
                leftCount = 0;
                rightCount = 0;

                parentChild.deleteCharAt(0);
                parentChild.deleteCharAt(parentChild.length() - 1);
                parentGroup.append(parentChild);
                parentChild = new StringBuilder();
            }
        }

        return parentGroup.toString();
    }
}