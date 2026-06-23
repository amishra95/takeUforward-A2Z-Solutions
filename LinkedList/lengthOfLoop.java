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
     public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return findLength(slow, fast);
            }
        }
        
        return 0;
    }

    public int findLength(ListNode slow, ListNode fast){
        int count = 1;
        fast = fast.next;

        while(slow != fast){
            count++;
            fast = fast.next;
        }
        return count;
    }
 }
