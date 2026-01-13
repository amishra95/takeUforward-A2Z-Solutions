class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        // Move fast pointer n steps ahead
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        // If fast is null, remove the head node
        if(fast == null){
            return head.next;
        }
        
        // Move both pointers until fast reaches the last node
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from end
        slow.next = slow.next.next;
        
        return head;
    }
}
