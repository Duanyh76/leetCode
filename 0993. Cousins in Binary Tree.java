class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Stack<TreeNode> checkingStack = new Stack();
        checkingStack.push(root);
        while (!checkingStack.isEmpty()) {
            boolean hasX = false;
            boolean hasY = false;
            Stack<TreeNode> todoStack = new Stack();
            while (!checkingStack.isEmpty()) {
                TreeNode node = checkingStack.pop();
                int checkSameParent = 0;
                if (node.left != null) {
                    todoStack.push(node.left);
                    if(node.left.val == x){
                        hasX = true;
                        checkSameParent++;
                    }
                    if(node.left.val == y){
                        hasY = true;
                        checkSameParent++;
                    }
                }
                if (node.right != null) {
                    todoStack.push(node.right);
                    if(node.right.val == x){
                        hasX = true;
                        checkSameParent++;
                    }
                    if(node.right.val == y){
                        hasY = true;
                        checkSameParent++;
                    }
                }
                if(checkSameParent == 2){
                    return false;
                }
            }
            if (hasX && hasY) {
                return true;
            }
            if (hasX != hasY) {
                return false;
            }
            checkingStack = todoStack;
        }
        return false;
    }
}