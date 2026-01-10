class Solution {
    public ListNode deleteHead(ListNode head) {
       
       if(head == null){
        return null;
       }  

       ListNode temp = head;
       head = head.next;
       
       temp = null;

       return head;

    }
}
