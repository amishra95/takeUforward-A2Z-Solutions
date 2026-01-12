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
    public ListNode sortList(ListNode head) {

       if(head == null){
            return null;
        }

        ListNode zeroPointer = new ListNode(-1);
        ListNode onePointer = new ListNode(-1);
        ListNode twoPointer = new ListNode(-1);


        ListNode zero = zeroPointer;
        ListNode one = onePointer;
        ListNode two = twoPointer;
        ListNode temp = head;

       
        while(temp != null){
            if(temp.data == 0){
                zeroPointer.next = temp;
                zeroPointer = temp;
            }
            else if(temp.data == 1){
                onePointer.next = temp;
                onePointer = temp;
            }
            else if(temp.data == 2){
                twoPointer.next = temp;
                twoPointer = temp;
            }

            temp = temp.next;
        
        }
   
        zeroPointer.next = null;
        onePointer.next = null;
        twoPointer.next = null;

        // Connect the three lists: zero -> one -> two
        zeroPointer.next = (one.next != null) ? one.next : two.next;
        onePointer.next = two.next;

        return zero.next;



    }
}
