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
    //[1,2,3,4,5] -> [1,3,5,2,4]
    public ListNode oddEvenList(ListNode head) {
        //YOUR CODE GOES HERE
        
        if(head == null){
            return null;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode firstEven = head.next;

    while(even != null && even.next != null){
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd = odd.next;
        even = even.next;
    }

    odd.next = firstEven;

    return head;

    }
}
