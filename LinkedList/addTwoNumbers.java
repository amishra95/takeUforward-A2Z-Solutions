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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      //Reverse both the value of nodes l1 and l2 and then add them and then reverse them

      
        if(l1 == null && l2 == null){
           return null;
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;

        while((l1 != null || l2 != null)|| carry != 0){
            int sum = 0;
            
            if(l1 != null){
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;

            carry = sum/10;

            ListNode node = new ListNode(sum %10);
            temp.next = node;
            
            temp = temp.next;
        }
            return dummy.next;

        }

    


    
}
