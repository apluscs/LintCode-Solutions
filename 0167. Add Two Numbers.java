public class Solution {
  /**
   * @param l1: the first list
   * @param l2: the second list
   * @return: the sum list of l1 and l2
   */
  public ListNode addLists(ListNode a, ListNode b) {
    ListNode result = new ListNode(0);
    ListNode curr = result;
    if (a == null && b == null) {
      return result;
    }
    int carry = 0;
    int sum = 0;
    while (a != null || b != null) {
      if (a == null) {
        sum = b.val + carry;
        b = b.next; //only move b
      } else if (b == null) {
        sum = a.val + carry;
        a = a.next;
      } else {
        sum = a.val + b.val + carry;    //carry is the overflow from the addition one unit before
        a = a.next;
        b = b.next;
      }
      carry = sum / 10;
      sum %= 10;    //part that doesn't overflow
      curr.next = new ListNode(sum);
      curr = curr.next;
    }
    if (carry > 0) {    //loop ignores this last overflowing value
      curr.next = new ListNode(carry);
    }
    return result.next;
  }
}
