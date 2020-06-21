class Solution {
    private List<Integer> list = new LinkedList();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        traver(root1);
        traver(root2);
        Collections.sort(list);
        return list;
    }
    
    private void traver(TreeNode node){
        if(node == null){
            return;
        }
        list.add(node.val);
        traver(node.left);
        traver(node.right);
    }
}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new LinkedList();
        Stack<TreeNode> a = new Stack();
        Stack<TreeNode> b = new Stack();
        pushLeft(a, root1);
        pushLeft(b, root2);
        while(!a.isEmpty() || !b.isEmpty()){
            int aValue = Integer.MAX_VALUE;
            int bValue = Integer.MAX_VALUE;
            if(!a.isEmpty()){
                aValue = a.peek().val;
            }
            if(!b.isEmpty()){
                bValue = b.peek().val;
            }
            if(aValue < bValue){
                list.add(aValue);
                pushLeft(a, a.pop().right);
            }else{
                list.add(bValue);
                pushLeft(b, b.pop().right);
            }
            
        }
        return list;
    }
    private void pushLeft(Stack<TreeNode> stack, TreeNode node){
        if(node == null){
            return;
        }
        stack.push(node);
        pushLeft(stack, node.left);
    }
}