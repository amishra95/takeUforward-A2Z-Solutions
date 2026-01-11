class Solution {
    public ListNode arrayToDoublyLinkedList(List<Integer> arr) {
        
        if(arr == null || arr.size() == 0) 
            return null;

            ListNode head = new ListNode(arr.get(0));
            ListNode prev = head;

        for(int i = 1; i < arr.size(); i++){
            ListNode temp = new ListNode(arr.get(i), prev,null);
            prev.next = temp;
            prev = temp;
        }
    
        return head;
    }

}
