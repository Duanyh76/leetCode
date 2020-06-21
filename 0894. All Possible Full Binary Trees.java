class Solution {
    private List<List<TreeNode>> record = new ArrayList();

    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return new ArrayList();
        }

        List<TreeNode> oneList = new ArrayList();
        oneList.add(new TreeNode(0));
        record.add(null);
        record.add(oneList);

        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) {
                record.add(null);
                continue;
            }
            List<TreeNode> list = new ArrayList();
            for (int leftNumber = 1; leftNumber < i - 1; leftNumber += 2) {
                int rightNumber = i - 1 - leftNumber;
                List<TreeNode> leftList = record.get(leftNumber);
                List<TreeNode> rightList = record.get(rightNumber);
                for (TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftNode;
                        root.right = rightNode;
                        list.add(root);
                    }
                }
            }
            record.add(list);
        }
        return record.get(N);
    }
}