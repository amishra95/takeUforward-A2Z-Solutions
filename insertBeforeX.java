class Solution {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
      
      //LinkedList == [1,2,3]
     
     if(head == null){
        return null;
      }
      
      if(head.data == X)
        return new ListNode(val, head);

        ListNode temp = head;
        while(temp.next != null){
            if(temp.next.data == X){
                ListNode newNode = new ListNode(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

      
        return head;

    }
}
