/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        
    ListNode temp = head;
    ListNode prev = null;

    while(temp != null){
        ListNode front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
    }

    return prev;

    }
}
