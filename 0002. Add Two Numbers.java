class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode l3 = preHead;
        int value = 0;
        while (l1 != null || l2 != null || value == 1) {
            int value1 = 0;
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
            }
            int value2 = 0;
            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
            }
            int value3 = value + value1 + value2;
            if (value3 >= 10) {
                value = 1;
                value3 -= 10;
            } else {
                value = 0;
            }
            ListNode newNode = new ListNode(value3);
            l3.next = newNode;
            l3 = l3.next;
        }
        return preHead.next;
    }
}