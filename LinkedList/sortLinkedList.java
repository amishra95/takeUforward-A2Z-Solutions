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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            list.add(current.val);
            current = current.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(0);
         current = dummy;

        for(int a : list){
            current.next = new ListNode(a);
            current = current.next;
        }

        return dummy.next;


    }
}
