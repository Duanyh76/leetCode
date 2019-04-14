/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sumLeaves(root, "");
    }

    private int sumLeaves(TreeNode root, String value) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return caculateValue(value + root.val);
        }
        int sum = 0;
        if (root.left != null) {
            sum += sumLeaves(root.left, value + root.val);
        }
        if (root.right != null) {
            sum += sumLeaves(root.right, value + root.val);
        }
        return sum;
    }

    private int caculateValue(String value) {
        char[] leafArray = value.toCharArray();
        int size = leafArray.length;
        int power = 1;
        int sum = 0;
        for (int index = size - 1; index >= 0; index--) {
            if (leafArray[index] == '1') {
                sum += power;
            }
            power *= 2;
        }
        return sum;
    }
}