/*
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public List<Integer> LLTraversal(ListNode head) {
      
      ListNode node = head;
        List<Integer> list = new ArrayList<>();

        while(node != null){
            list.add(node.data);
            node = node.next;

    }

    return list;
}
}
