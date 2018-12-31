public class Solution {
  /**
   * @param head: The first node of linked list.
   * @return: The head of linked list.
   */
  public ListNode insertionSortList(ListNode head) { /// head will stay where it is
    ListNode start = new ListNode(-1);
    start.next = head;
    ListNode prev = start;
    ListNode curr = head;
    while (curr != null) {
      ListNode poss = start;
      while (poss.next != curr && poss.next.val <= curr.val) { // insert as far back as possible to avoid infinite loop {ex. two equivalent values are swapped, and when curr moves ahead one, it reaches the one it just switched with}
        poss = poss.next;
      }
      ListNode temp = curr;
      if (poss.next != curr) { // swap needs to be made
        prev.next = curr.next;
        curr.next = poss.next;
        poss.next = curr;
      }
      prev = temp;
      curr = temp.next;
    }
    return start.next;
  }
}
