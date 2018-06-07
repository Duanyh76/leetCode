class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            for (int index = 0; index < level.size(); index++) {
                TreeNode node = level.get(index);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            if (nextLevel.isEmpty()) {
                break;
            }
            level = nextLevel;
            nextLevel = new ArrayList<>();
        }
        return level.get(0).val;
    }
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        TreeNode node = null;
        while (!level.isEmpty()) {
            node = level.poll();
            if (node.right != null) {
                level.add(node.right);
            }
            if (node.left != null) {
                level.add(node.left);
            }
        }
        return node.val;
    }
}