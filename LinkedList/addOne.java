// This is the first phase of the solution and is incomplete. ( Will come-back after a breaK to complete this)
class Solution {
    public ListNode addOne(ListNode head) {

        LinkedList<Integer> list = new LinkedList<>();

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        Integer[] arr = new Integer[list.size()];
                list.toArray(arr);

        int carry = 1;

        for(int i = arr.length-1; i>= 0; i--){
            int sum = arr[i] + carry;
            arr[i] = sum % 10; // find the real remainder 
            carry = sum/10;

            if(carry == 0) break;

        }
        

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        if(carry > 0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        
        // Add remaining digits
        for(int i = 0; i < arr.length; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        
        return dummy.next;

        

    }
    
}
