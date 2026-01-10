class Solution {
    public ListNode deleteTail(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }
// 1->2->5 (1->2)
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        ListNode newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;

        return head;

    }
}
