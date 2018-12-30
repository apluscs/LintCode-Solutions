/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
  public ListNode partition(ListNode head, int x) {
    ListNode start = new ListNode(-1);
    ListNode end = new ListNode(-1); // need these to mark the start of the chains
    ListNode left = start;
    ListNode right = end;
    while (head != null) {
      if (head.val < x) {
        left.next = head;
        left = left.next;
      } else {
        right.next = head;
        right = right.next;
      }
      head = head.next;
    }
    right.next = null; // this line is essential for memory usage - why??
    left.next = end.next; // connects end of first chain to start of second chain
    return start.next;
  }
}
