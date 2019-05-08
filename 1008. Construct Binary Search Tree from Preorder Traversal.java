class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int begin, int end) {
        if (begin > end) {
            return null;
        }
        if (begin == end) {
            return new TreeNode(preorder[begin]);
        }
        TreeNode root = new TreeNode(preorder[begin]);
        int rightIndex = getRightIndex(preorder, begin, end);
        root.left = buildTree(preorder, begin + 1, rightIndex - 1);
        root.right = buildTree(preorder, rightIndex, end);
        return root;
    }

    private int getRightIndex(int[] preorder, int begin, int end) {
        int rootValue = preorder[begin];
        int rightIndex = begin + 1;
        while (rightIndex <= end && preorder[rightIndex] < rootValue) {
            rightIndex++;
        }
        return rightIndex;
    }
}