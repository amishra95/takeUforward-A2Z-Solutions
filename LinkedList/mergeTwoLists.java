// Best case scenario
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null){
            current.next = list1;
        }
        else{
            current.next = list2;
        }

        return dummy.next;

    }
}

// Worst-Case Scenario in terms of time complexity and space complexity
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode current1 = list1;
        while(current1 != null){
            list.add(current1.val);
            current1 = current1.next;
        }
            
        ListNode current2 = list2;
         while(current2 != null){
                list.add(current2.val);
                current2 = current2.next;
            }

        Collections.sort(list);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for(int a : list){
            current.next = new ListNode(a);
            current = current.next;
        }

        return dummy.next;

    }
}
