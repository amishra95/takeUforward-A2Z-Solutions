class Solution {
    public List<Integer> LLTraversal(ListNode head) {
        
        List<Integer> list = new ArrayList<Integer>();
        ListNode node = head;

        while(node != null){
            list.add(node.data);
            node = node.next;

        }
    
        return list;
    }
}
