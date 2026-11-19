/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

    int lenA = length(headA);
    int lenB = length(headB);

    if(lenA > lenB){
        int diff = lenA - lenB;
        while(diff > 0){
            headA = headA.next;
            diff--;
        }
    }
    else if(lenB > lenA){
        int diff = lenB - lenA;
        while(diff > 0){
            headB = headB.next;
            diff--;
        }
    } 
    while(headA != headB){
        headA = headA.next;
        headB = headB.next;
    }
     return headA;   
     }

     public int length(ListNode a){
        int count = 0;
        while(a != null){
            count++;
            a = a.next;
        }
        return count;
     }

}
