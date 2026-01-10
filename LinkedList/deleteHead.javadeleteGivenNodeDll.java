class Solution {
    /* Function to delete the given node 
    from doubly linked list */
    public void deleteGivenNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode front = node.next;

        // Edge case if the given node is the tail node
        if (front == null) {
            prev.next = null;
            node.prev = null;
            return;
        }

        // Disconnect node 
        prev.next = front;
        front.prev = prev;

        // Set node's pointers to null
        node.next = null;
        node.prev = null;
    }
}
