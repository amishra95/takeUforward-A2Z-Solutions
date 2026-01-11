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
    public void insertBeforeGivenNode(ListNode node, int X) {
        ListNode newNode = new ListNode(X);

        newNode.prev = node.prev;
        newNode.next = node;
        
        if (node.prev != null) {
            node.prev.next = newNode;
        }
            node.prev = newNode;

    }
}
