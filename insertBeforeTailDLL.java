
class Solution {
    public ListNode insertBeforeTail(ListNode head, int X) {
        if(head.next == null){
            ListNode newHead = new ListNode(X, null, head);
            head.prev = newHead;
            return newHead;
        }

        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        ListNode prev = tail.prev;
        ListNode newNode = new ListNode(X, prev, tail);

        prev.next = newNode;
        tail.prev = newNode;

        return head;

    }
}
