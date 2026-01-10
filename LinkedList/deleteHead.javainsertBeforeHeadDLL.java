class Solution {
    public ListNode insertBeforeHead(ListNode head, int data) {

        ListNode newHead = new ListNode(data, null, head);
        head.prev = newHead;
        return newHead;
    }
}
