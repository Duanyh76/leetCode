class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (val != node.val) {
                return false;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return true;
    }
}