class Solution {
    public int goodNodes(TreeNode root) {
        return checkRoot(root, root.val);
    }
    
    private int checkRoot(TreeNode root, int value){
        if(root == null){
            return 0;
        }
        int maxValue = Math.max(root.val, value);
        int rightNumber = checkRoot(root.right, maxValue);
        int leftNumber = checkRoot(root.left, maxValue);
        int thisNumber = root.val >= value ? 1 : 0;
        return rightNumber + leftNumber + thisNumber;
    }
}