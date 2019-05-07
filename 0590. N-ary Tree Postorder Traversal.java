class Solution {
    private List<Integer> valueList = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        travel(root);
        return valueList;
    }

    private void travel(Node root) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            travel(node);
        }
        valueList.add(root.val);
    }
}