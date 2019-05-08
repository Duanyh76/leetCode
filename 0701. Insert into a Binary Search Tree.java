class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        int originValue = root.val;
        root.val = val;
        if (originValue > val) {
            // go to right
            if (root.right == null) {
                TreeNode node = new TreeNode(originValue);
                root.right = node;
            } else {
                root.right = insertIntoBST(root.right, originValue);
            }
        } else {
            // go to left
            if (root.left == null) {
                TreeNode node = new TreeNode(originValue);
                root.left = node;
            } else {
                root.left = insertIntoBST(root.left, originValue);
            }
        }
        return root;
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root.val > val) {
            // go to left
            if (root.left == null) {
                TreeNode node = new TreeNode(val);
                root.left = node;
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        } else {
            // go to right
            if (root.right == null) {
                TreeNode node = new TreeNode(val);
                root.right = node;
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }
        return root;
    }
}