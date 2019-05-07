class Solution {
    private List<Integer> valueList = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        travel(root);
        return valueList;
    }

    private void travel(Node root) {
        if (root == null) {
            return;
        }
        valueList.add(root.val);
        for (Node node : root.children) {
            travel(node);
        }
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> valueList = new ArrayList<>();
        if (root == null) {
            return valueList;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(root);
        while (!nodeStack.empty()) {
            Node node = nodeStack.pop();
            valueList.add(node.val);
            Stack<Node> childStack = new Stack<>();
            for (Node child : node.children) {
                childStack.add(child);
            }
            while (!childStack.empty()) {
                nodeStack.add(childStack.pop());
            }
        }
        return valueList;
    }
}