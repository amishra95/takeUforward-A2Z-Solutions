class Solution {
    public ListNode deleteHead(ListNode head) {
       
         if(head == null || head.next == null){
            return null;
        }

    //Store current head as prev
        ListNode prev = head;
       //Move head to next node 
        head = head.next;
        //Set prev pointer as null
        head.prev = null;
        //set next pointer
        prev.next = null;
        return head;
    }
}
