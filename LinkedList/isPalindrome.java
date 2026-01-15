class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        ListNode fast = head;  // Bug fix: should start at head, not head.next
        ListNode slow = head;

        // Bug fix: condition should be && not ||, and check fast != null first
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;  // Bug fix: firstHalf was not declared
        ListNode secondHalfCopy = secondHalf;

        while(secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Optional: Restore the list
        // reverseList(secondHalfCopy);

        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode nextNode = current.next;  // Bug fix: was nextnode, used as nextNode
            current.next = prev;
            prev = current;
            current = nextNode;
        }
    
        return prev;
    }
}
