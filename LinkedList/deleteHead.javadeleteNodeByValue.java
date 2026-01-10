class Solution {
  public ListNode deleteNodeWithValueX(ListNode head, int X) {
    if (head == null) {
      return head;
    }
    if (head.data == X) {
      head = head.next;
      return head;
    }

    ListNode temp = head;
    ListNode prev = null;

    while (temp != null) {
      if (temp.data == X) {
        prev.next = temp.next;
        return head;
      }
      prev = temp;
      temp = temp.next;
    }
    return head;
  }
}
