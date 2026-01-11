/*
// Definition for a Node.
class ListNode {
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode();
    public ListNode(int data);
    public ListNode(int data, ListNode prev, ListNode next);
};
*/

class Solution {
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
        
        if(K ==1){
            ListNode newHead = new ListNode(X, null, head);
            head.prev = newHead;
            return newHead;
        }

        ListNode node = head;

    int count = 0;
        while(node != null){
            count++;
            if(count == K) break;
            node = node.next;
        }
        ListNode prev = node.prev;
                // Create new node with data as X
        ListNode newNode = new ListNode(X, prev, node);

        // Join new node 
        prev.next = newNode;
        node.prev = newNode;

        // Return head 
        return head;


    }
}
