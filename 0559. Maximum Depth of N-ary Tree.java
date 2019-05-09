class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int depth = 0;
        for (Node node : root.children) {
            depth = Math.max(maxDepth(node), depth);
        }
        return 1 + depth;
    }
}