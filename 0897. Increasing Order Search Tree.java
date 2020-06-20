class Solution {
    public TreeNode increasingBST(TreeNode root) {
        boolean[] record = new boolean[1001];
        recordTree(root, record);
        TreeNode node = root;
        for (int i = 0; i <= 1000; i++) {
            if (record[i] == true) {
                node.right = new TreeNode(i);
                node = node.right;
            }
        }
        return root.right;
    }

    private void recordTree(TreeNode node, boolean[] record) {
        if (node != null) {
            record[node.val] = true;
        }
        if (node.left != null) {
            recordTree(node.left, record);
        }
        if (node.right != null) {
            recordTree(node.right, record);
        }
    }
}