class Solution {
    private int baseValue = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root.left == null && root.right == null) {
            root.val += baseValue;
            baseValue = root.val;
        }
        if (root.right != null) {
            root.right = bstToGst(root.right);
            root.val += baseValue;
            baseValue = root.val;
        }
        if (root.left != null) {
            root.left = bstToGst(root.left);
        }
        return root;
    }
}