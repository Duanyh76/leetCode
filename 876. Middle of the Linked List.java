class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        while (fastIndex != null && fastIndex.next != null) {
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
        }
        return slowIndex;
    }
}